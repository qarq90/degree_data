class employee:
    def __init__(self, name, dept, sal):
        self.name = name
        self.dept = dept
        self.sal = sal

    def put_data(self):
        print("Employee Name: " , self.name)
        print("Employee Department: " , self.dept)
        print("Employee Salary: " , self.sal)
        
