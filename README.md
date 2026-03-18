# Spring AI: Multi-LLM Integration (OpenAI & Mistral via Ollama)

This project is a flexible Spring Boot gateway designed to interact with both Cloud-based (**OpenAI**) and Locally-hosted (**Ollama**) Large Language Models.
It demonstrates how to build a provider-agnostic AI service layer using **Spring AI**.

## 🚀 Key Features
* **Hybrid AI Strategy:** Seamlessly switch between high-reasoning Cloud models and privacy-focused Local models.
* **Modern API Design:** Uses RESTful Path Variables for intuitive prompting.
* **Java 21 & Spring Boot 4.0 +:** Leveraging the latest ecosystem features for optimal performance.

---

## 🛠 Prerequisites & Setup

### 1. Local LLM: Ollama (Mistral)
To use the local model functionality, you must have **Ollama** installed and the **Mistral** model pulled to your local library.
* **Download:** [ollama.com](https://ollama.com/)
* **Setup:** Open your terminal and run:
  ```bash
  ollama pull mistral
  ```
* **Run:** Ensure the Ollama server is active before launching the Spring Boot app:
  ```bash
  ollama serve
  ```

### 2. Cloud LLM: OpenAI
The application is configured to securely read your OpenAI API Key from an environment variable at runtime.
* **Configuration:** In `application.properties`, the key is mapped as:
  ```properties
  spring.ai.openai.api-key=${OPENAI_API_KEY}
  ```

---

## 🏃 How to Run

### Step 1: Set Environment Variable
You must provide your API key to the runtime environment.
* **Linux/macOS:** `export OPENAI_API_KEY='your_key_here'`
* **Windows (PS):** `$env:OPENAI_API_KEY="your_key_here"`

### Step 2: Build and Launch
```bash
mvn clean install
mvn spring-boot:run
```

---

## 🔌 API Endpoints

The service uses path-based variables to capture your questions:

| Provider | Endpoint | Example Usage |
| :--- | :--- | :--- |
| **OpenAI** | `GET /openai/ask/{message}` | `http://localhost:8080/openai/ask/What is Spring AI?` |
| **Ollama** | `GET /ollama/ask/{message}` | `http://localhost:8080/ollama/ask/Tell me about Mistral.` |

---

## 📝 Learning Objectives
* **Model Orchestration:** Coordinating different `ChatModel` beans (OpenAI vs. Ollama) within the same application context.
* **Local Inference:** Evaluating the performance and latency of the **Mistral** model running on local hardware.
* **Secure Property Management:** Avoiding hardcoded credentials by using `${VAR}` injection in Spring properties.

