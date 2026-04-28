import requests
from langchain.tools import tool
from api_client import *

from dataclasses import dataclass
from typing import Optional

@dataclass
class TaskUpdate:
    title: Optional[str] = None
    description: Optional[str] = None
    status: Optional[str] = None
    assigneeEmail: Optional[str] = None

def to_payload(update: TaskUpdate) -> dict:
    return {k: v for k, v in update.__dict__.items() if v is not None}

@tool
def create_task(title: str, description: str, status: str) -> str:
    """Create a new task via the backend API."""
    try:
        response = api_request("post","/api/tasks",
                               json={
                                    "title": title,
                                    "description": description,
                                    "status": status
                                    }
                               )
        if response.status_code in [200, 201]:
            return f"Task created successfully: {response.json()}"
        else:
            return f"Failed: {response.status_code} - {response.text}"

    except Exception as e:
        print("from catch")
        return f"Error: {str(e)}"

@tool
def update_task(id: int, task : TaskUpdate) -> str:
    """
    Update an existing task. Only provided fields will be updated.
    """
    # filter None values
    payload = to_payload(task)

    if not payload:
        return "No fields provided to update."
    try:
        response = api_request("put", f"/api/tasks/{id}", json=payload)

        if response.status_code in [200, 201]:
            return f"Task updated successfully: {response.json()}"
        else:
            return f"Failed: {response.status_code} - {response.text}"
    except Exception as e:
        return f"Error: {str(e)}"
    
@tool
def get_all_task()->str:
    """fetch the all task list using following url."""
    try:
        response = api_request("get","/api/tasks")

        if response.status_code in [200, 201]:
            return f"Task fetched successfully: {response.json()}"
        else:
            return f"Failed: {response.status_code} - {response.text}"

    except Exception as e:
        return f"Error: {str(e)}"

@tool
def get_task_by_id(id:int)->str:
    """fetch the task by id."""
    try:
        response = api_request("get",f"/api/tasks{id}")

        if response.status_code in [200, 201]:
            return f"Task fetched successfully: {response.json()}"
        else:
            return f"Failed: {response.status_code} - {response.text}"

    except Exception as e:
        return f"Error: {str(e)}"
    
@tool
def delete_task(id:int) -> str:
    """Delete a task by its ID."""
    try:
        response = api_request("delete", f"/api/tasks/{id}")

        if response.status_code in [200, 204]:
            return f"Task deleted Successfully"
        else:
            return f"Failed: {response.status_code} - {response.text}"
    except Exception as e:
        return f"Error: {str(e)}"