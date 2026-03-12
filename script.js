let employees = []

function addEmployee(){

let id=document.getElementById("empId").value
let name=document.getElementById("empName").value
let salary=parseFloat(document.getElementById("salary").value)
let bonus=parseFloat(document.getElementById("bonus").value)
let deduction=parseFloat(document.getElementById("deduction").value)

let netSalary = salary + bonus - deduction

let employee={
id:id,
name:name,
salary:salary,
bonus:bonus,
deduction:deduction,
netSalary:netSalary
}

employees.push(employee)

displayEmployees()

clearFields()

}

function displayEmployees(){

let table=document.getElementById("employeeTable")

table.innerHTML=""

employees.forEach((emp,index)=>{

let row=`
<tr>
<td>${emp.id}</td>
<td>${emp.name}</td>
<td>${emp.salary}</td>
<td>${emp.bonus}</td>
<td>${emp.deduction}</td>
<td>${emp.netSalary}</td>
<td>
<button onclick="deleteEmployee(${index})">Delete</button>
</td>
</tr>
`

table.innerHTML+=row

})

}

function deleteEmployee(index){

employees.splice(index,1)

displayEmployees()

}

function searchEmployee(){

let searchId=document.getElementById("searchId").value

let result=employees.find(emp=>emp.id==searchId)

if(result){

alert(
"Employee Found\n\n"+
"Name: "+result.name+"\n"+
"Net Salary: "+result.netSalary
)

}
else{
alert("Employee Not Found")
}

}

function clearFields(){

document.getElementById("empId").value=""
document.getElementById("empName").value=""
document.getElementById("salary").value=""
document.getElementById("bonus").value=""
document.getElementById("deduction").value=""

}