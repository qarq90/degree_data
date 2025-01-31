student_info = {
    "name": "qarq90",
    "roll_no": 242466,
    "branch": "Information Technology",
    "subject": "Python",
    "faculty": "Zainab Mam"
}

print("1. Get Method ('name'):", student_info.get("name"))  
print("2. Keys Method:", student_info.keys())  
print("3. Values Method:", student_info.values())  
print("4. Items Method:", student_info.items())  
student_info.update({"college": "Saboo Siddik", "grade": "A"})
print("5. Update Method:", student_info)  
removed_value = student_info.pop("subject")
print("6. Pop Method (Removed 'subject'):", removed_value)
print("Updated Dictionary:", student_info)
last_item = student_info.popitem()
print("7. Popitem Method (Removed last item):", last_item)
print("Updated Dictionary:", student_info)
default_value = student_info.setdefault("hobby", "Reading")
print("8. Setdefault Method (Added 'hobby'):", student_info)
copied_dict = student_info.copy()
print("9. Copy Method (Copied Dictionary):", copied_dict)
student_info.clear()
print("10. Clear Method (After Clearing Dictionary):", student_info)
