const url = 'http://localhost:8080/spring-binding-data/api/students';


function showAllStudents() {
    fetch(url)
        .then(response => response.json())
        .then(student => {
            let tbody = document.querySelector('tbody');
            tbody.innerHTML = '';
            for (let i = 0; i < student.length; i++) {
                let tr = document.createElement('tr');
                tbody.insertAdjacentElement('beforeend', tr);

                for (let val in student[i]) {
                    let td = document.createElement('td');
                    td.appendChild(document.createTextNode(student[i][val]));
                    tr.insertAdjacentElement('beforeend', td);
                }

                let inpDel = document.createElement('input');
                inpDel.setAttribute('data-id', student[i].id);
                inpDel.setAttribute('value', 'Delete');
                inpDel.setAttribute('type', 'submit');
                inpDel.setAttribute('id', 'del');
                tr.append(inpDel);

                deleteStudent(inpDel);

                let inpUpd = document.createElement('input');
                inpUpd.setAttribute('data-id', student[i].id);
                inpUpd.setAttribute('value', 'Update');
                inpUpd.setAttribute('type', 'submit');
                inpUpd.setAttribute('id', 'upd');
                tr.append(inpUpd);

                updateStudent(inpUpd);
            }
        });
}

showAllStudents();


function deleteStudent(inpDel) {
    inpDel.addEventListener('click', function () {
        let id = this.getAttribute('data-id');
        console.log(id);
        fetch(url + '/' + id, {
            method: 'DELETE'
        })
            .then(response => {
                console.log(response.status);
                this.parentNode.parentNode.removeChild(this.parentNode);
            })

    });
}

function updateStudent(inpUpd) {
    inpUpd.addEventListener('click', function () {
        let id = this.getAttribute('data-id');
        console.log(id);
        confirm('WARNING: Вводите данные корректно, проверки на валидность нет :-)');

        let newDataOfStudent = {
            firstName: prompt("Укажите новую фамилию студента"),
            lastName: prompt("Укажите новое имя студента"),
            age: prompt("Укажите новый возраст студента цифрой"),
            group: prompt("Укажите новой номер группу студента:\n" +
                "Java - 1\n " +
                "PHP - 2\n " +
                "SQL - 3\n " +
                "JavaScript - 4")

        };
        console.log(newDataOfStudent);
        fetch(url + "/" + id, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(newDataOfStudent)
        }).then(response => {
            if (response.status < 400) {
                showAllStudents();
            }
        })
    })
}



