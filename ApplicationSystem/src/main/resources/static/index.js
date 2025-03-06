fetch('http://localhost:8080/applications')
  .then(response => response.json())
  .then(applications => {
    const tableBody = document.querySelector('#businessDetailsTable tbody');

    applications.forEach(app => {
      const row = document.createElement('tr');
      row.addEventListener('dblclick', () => {
        // Assuming 'app' now has a businessDetailsId property
        window.location.href = `edit.html?id=${app.businessDetails.id}`;
      });

      const idCell = document.createElement('td');
      idCell.textContent = app.businessDetails.id; // Accessing properties from businessDetails
      row.appendChild(idCell);

      const nameCell = document.createElement('td');
      nameCell.textContent = app.businessDetails.name; // Accessing properties from businessDetails
      row.appendChild(nameCell);

      // ... similarly for other cells, accessing properties from app.businessDetails

      const applicationStatusCell = document.createElement('td');
      applicationStatusCell.textContent = app.status; // Accessing status directly from app
      row.appendChild(applicationStatusCell);

      tableBody.appendChild(row);
    });
  })
  .catch(error => console.error('Error fetching applications:', error));
