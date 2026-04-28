from langchain_ollama import ChatOllama
from langchain.tools import tool
from langchain.agents import create_agent
from tools.task import *
from config import *
import requests

from langchain_openrouter import ChatOpenRouter

model = ChatOpenRouter(
    model="openai/gpt-oss-20b:free",
    temperature=0.8,
    api_key=OPENROUTER_API_KEY
)
# model = ChatOllama(
#     model="mistral",
#     temperature=.5
# )

agent = create_agent(
    model=model,
    tools=[create_task, get_all_task, get_task_by_id, update_task, delete_task],
    system_prompt="You are a helpful assistant."
)

while(True):
    prompt = input("You: ")
    result = agent.invoke(
        {"messages": [{"role": "user", "content": prompt}]}
    )
    print("AI: " , result["messages"][-1].content)
