<#import "partials/main.ftlh" as main />
<@main.renderWith styles=["../css/main.css","https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css","https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"]>
    <br>
    <h2>Add new place</h2>
    <br>
    <form action="/user/add-place" method="post" enctype="multipart/form-data">
        <div class="row">
            <div class="col-6">
                <h5>Title</h5>
            </div>
            <div class="col-6">
                <input type="text" class="w-100" name="name">
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-6">
                <h5>Description</h5>
            </div>
            <div class="col-6">
                <textarea name="description" class="w-100 h-100"></textarea>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-6">
                <h5>Main Photo</h5>
            </div>
            <div class="col-6">
                <input type="file" name="file">
            </div>
        </div>
        <br>
        <button type="submit" class="btn btn-primary w-100">Add</button>
    </form>

</@main.renderWith>