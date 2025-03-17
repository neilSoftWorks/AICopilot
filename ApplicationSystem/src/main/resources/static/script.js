fetch('/applications')
    .then(response => response.json())
    .then(data => {
        const tableBody = document.querySelector('#applicationTable tbody');
        data.forEach(app => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${app.id}</td>
                <td>${app.name}</td>
                <td>${app.contactDetails}</td>
                <td>${app.address}</td>
                <td>${app.industry}</td>
                <td>${app.phoneNumber}</td>
                <td>${app.financialInformation}</td>
                <td>${app.emailAddress}</td>
                <td>${app.applicationStatusId}</td>
                <td><a href=\"/edit/${app.id}\">Edit</a></td>
            `;
            tableBody.appendChild(row);
        });
    });