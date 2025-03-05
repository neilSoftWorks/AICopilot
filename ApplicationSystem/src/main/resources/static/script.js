document.addEventListener('DOMContentLoaded', function() {
    const table = document.getElementById('businessDetailsTable').getElementsByTagName('tbody')[0];

    function loadBusinessDetails() {
        fetch('http://localhost:8080/applications')
            .then(response => response.json())
            .then(data => {
                table.innerHTML = '';
                data.forEach(detail => {
                    let row = table.insertRow();
                    let idCell = row.insertCell(0);
                    let nameCell = row.insertCell(1);
                    let addressCell = row.insertCell(2);
                    let contactDetailsCell = row.insertCell(3);
                    let phoneCell = row.insertCell(4);
                    let emailCell = row.insertCell(5);
                    let industryCell = row.insertCell(6);
                    let financialInformationCell = row.insertCell(7);

                    idCell.textContent = detail.id;
                    nameCell.textContent = detail.name;
                    addressCell.textContent = detail.address;
                    contactDetailsCell.textContent = detail.contactDetails;
                    phoneCell.textContent = detail.phoneNumber;
                    emailCell.textContent = detail.emailAddress;
                    industryCell.textContent = detail.industry;
                    financialInformationCell.textContent = detail.financialInformation;

                    row.addEventListener('dblclick', function() {
                        handleRowDoubleClick(detail.id);
                    });
                });
            })
            .catch(error => console.error('Error fetching business details:', error));
    }

    function handleRowDoubleClick(id) {
        if (confirm("Edit or Delete ID: " + id + "? (OK to Edit, Cancel to Delete)")) {
            editBusinessDetails(id);
        } else {
            deleteBusinessDetails(id);
        }
    }

    function editBusinessDetails(id) {
        window.location.href = `edit.html?id=${id}`;
    }

    function deleteBusinessDetails(id) {
        fetch(`http://localhost:8080/applications/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                alert('Business details deleted successfully.');
                loadBusinessDetails();
            } else {
                alert('Failed to delete business details.');
            }
        })
        .catch(error => console.error('Error deleting business details:', error));
    }

    loadBusinessDetails();
});
