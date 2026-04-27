import requests
from config import *

def get_headers():
    return {
        "Authorization": f"Bearer {STMS_API_KEY}",
        "Content-Type": "application/json"
    }

def api_request(method: str, endpoint: str, **kwargs):
    response = requests.request(
        method,
        f"{STMS_BASE_URL}{endpoint}",
        headers=get_headers(),
        **kwargs
    )
    return response