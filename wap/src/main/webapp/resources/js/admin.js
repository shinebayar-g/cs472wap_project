
    function deleteAjax(itemId) {
        $.ajax({
            type: 'POST',
            url: 'AjaxController',
            data: {
                course_code: itemId,
                action: 'delete'
            },
            success: function (result) {
                //    alert("Return Result from Delete :" + result);
                load();
            }
        });
    }

function fetchRowData(rowIndex) {
    let rowData = document.getElementById("tbl").rows[rowIndex];

    document.getElementById('course_code').value = rowData.cells[0].innerHTML;
    document.getElementById('course_name').value = rowData.cells[1].innerHTML;
    document.getElementById('course_credits').value = rowData.cells[2].innerHTML;
    document.getElementById('course_instructor').value = rowData.cells[3].innerHTML;
}

function deleteRow(rowIndex) {
    let rowData = document.getElementById("tbl").rows[rowIndex];
    //Create Ajax Call to Delete from the Backend
    let itemId = parseInt(rowData.cells[0].innerHTML);
    deleteAjax(itemId);
    //Delete From the UI
    document.getElementById("tbl").deleteRow(rowIndex);
}

$(document).ready(function () {
    function load() {
        $.ajax({
            type: 'GET',
            url: 'AjaxController',
            success: function (result) {
                //alert(result);
                let JSONObjectArray =  result;
                let table =  document.getElementById("tbl");
                let rowCount = document.getElementById("tbl").rows.length;
                for(let i = 0 ; i < JSONObjectArray.length ; i++ )
                {
                    let JSONObject = JSONObjectArray[i];
                    let row = table.insertRow(i+1);
                    let cell1 = row.insertCell(0);
                    let cell2 = row.insertCell(1);
                    let cell3 = row.insertCell(2);
                    let cell4 = row.insertCell(3);

                    cell1.innerHTML = JSONObject.id;
                    cell2.innerHTML = JSONObject.name;
                    cell3.innerHTML = JSONObject.credit;
                    cell4.innerHTML = JSONObject.instructor;

                    /**************************** Edit Button *****************************/
                    var editButton = document.createElement('input');
                    editButton.setAttribute('type', 'button');
                    editButton.setAttribute('value', 'Edit');
                    editButton.setAttribute('onclick', 'fetchRowData('+ (i+1) +')');
                    row.appendChild(editButton);
                    /**************************** Delete Button *****************************/
                    var deleteButton = document.createElement('input');
                    deleteButton.setAttribute('type', 'button');
                    deleteButton.setAttribute('value', 'Delete');
                    deleteButton.setAttribute('onclick', 'deleteRow('+ (i+1) +')');
                    row.appendChild(deleteButton);
                }

            }
        });

    }

    load();


    $('#btnAdd').click(function () {
        let id = $('#course_code').val();
        let name = $('#course_name').val();
        let credit = $('#course_credits').val();
        let instructor = $('#course_instructor').val();

        $.ajax({
            type: 'POST',
            data: {
                course_code: id,
                course_name: name,
                course_credits: credit,
                course_instructor: instructor,
                action: 'add'
            },
            url: 'AjaxController',
            success: function (result) {
                let JSONObject = result;
                let table =  document.getElementById("tbl");
                let rowCount = table.rows.length;

                alert("Row Count " + rowCount);
                let row = table.insertRow(rowCount);
                let cell1 = row.insertCell(0);
                let cell2 = row.insertCell(1);
                let cell3 = row.insertCell(2);
                let cell4 = row.insertCell(3);
                //let cell3 = row.insertCell(2);

                cell1.innerHTML = JSONObject.id;
                cell2.innerHTML = JSONObject.name;
                cell3.innerHTML = JSONObject.credit;
                cell4.innerHTML = JSONObject.instructor;

                /**************************** Edit Button *****************************/
                let editButton = document.createElement('input');
                editButton.setAttribute('type', 'button');
                editButton.setAttribute('value', 'Edit');
                editButton.setAttribute('onclick', 'fetchRowData('+ (i+1) +');');
                row.appendChild(editButton);
                /**************************** Delete Button *****************************/
                let deleteButton = document.createElement('input');
                deleteButton.setAttribute('type', 'button');
                deleteButton.setAttribute('value', 'Delete');
                deleteButton.setAttribute('onclick', 'deleteRow('+ (i+1) +');');
                row.appendChild(deleteButton);
            }
        });

        //re build the UI elements=> Buttons
        window.location.reload();
    });

    $('#btnSaveEdit').click(function () {
        //course_code course_name course_credits course_instructor

        let id = $('#course_code').val();
        let name = $('#course_name').val();
        let credit = $('#course_credits').val();
        let instructor = $('#course_instructor').val();

        $.ajax({
            type: 'POST',
            data: {
                course_code: id,
                course_name: name,
                course_credits: credit,
                course_instructor: instructor,

                action: 'saveupdate'
            },
            url: 'AjaxController',
            success: function (result) {
                //alert(result);
                let JSONObjectArray =  result;
                let table =  document.getElementById("tbl");
                let rowCount = document.getElementById("tbl").rows.length;
                for(let i = 0 ; i < JSONObjectArray.length ; i++ )
                {
                    let JSONObject = JSONObjectArray[i];
                    let row = table.insertRow(i+1);
                    let cell1 = row.insertCell(0);
                    let cell2 = row.insertCell(1);
                    let cell3 = row.insertCell(2);
                    let cell4 = row.insertCell(3);

                    cell1.innerHTML = JSONObject.id;
                    cell2.innerHTML = JSONObject.name;
                    cell3.innerHTML = JSONObject.credit;
                    cell4.innerHTML = JSONObject.instructor;

                    /**************************** Add Button *****************************/
                    var editButton = document.createElement('input');
                    editButton.setAttribute('type', 'button');
                    editButton.setAttribute('value', 'Edit');
                    editButton.setAttribute('onclick', 'fetchRowData('+ (i+1) +')');
                    row.appendChild(editButton);
                    /**************************** Delete Button *****************************/
                    var deleteButton = document.createElement('input');
                    deleteButton.setAttribute('type', 'button');
                    deleteButton.setAttribute('value', 'Delete');
                    deleteButton.setAttribute('onclick', 'deleteRow('+ (i+1) +')');
                    row.appendChild(deleteButton);
                }

            }
        });
        window.location.reload();
        //re build the UI elements=> Buttons
        //location.reload();
    });
});
