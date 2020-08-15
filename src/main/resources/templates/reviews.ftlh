<#import "partials/main.ftlh" as main />
<@main.renderWith styles=["css/main.css","https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css","https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"]>
    <div class="row">
        <div class="col-6">
            <h2>${place.name}</h2>
            <br>
            <h5>${place.description}</h5>
        </div>
        <div class="col-6">
            <img src="http://localhost:7777/image/${image.id}" alt="">
        </div>
        <br>
        <h4>Gallery</h4>
        <div class="row">
            <#list images as img>
                <div class="col-2">
                    <img src="http://localhost:7777/image/${image.id}" alt="">
                </div>
            </#list>
        </div>
        <br>
        <h4>Rating: ${review.rating}.0</h4>
        <br>
        <h4>Reviews</h4>
        <br>
        <#list reviews as rev>
            <p>On ${rev.ldt}, ${rev.user.name} said:</p>
            <p>${rev.review}</p>
            <p>Rating: ${rev.rating}</p>
        </#list>
        <#if user??>
            <h4>Add review</h4>
            <br>
            <form action="" method="post">
                <input type="hidden" name="user_id" value="${user.id}">
                <input type="hidden" name="place_id" value="${place.id}">
                <textarea name="review" id="" class="w-100 h-30"></textarea>
                <br>
                <p><label for="rating" class="col-form-label">Rating</label></p>
                <select class="form-control" id="rating" name="rating">
                    <option value="5">5</option>
                    <option value="4">4</option>
                    <option value="3">3</option>
                    <option value="2">2</option>
                    <option value="1">1</option>
                </select>
                <br>
                <button type="submit" class="btn btn-primary">Ok</button>
            </form>
            <br>
            <h4>Upload new photo</h4>
            <br>
            <form action="" method="post" enctype="multipart/form-data">
                <input type="hidden" name="place_id" value="${place.id}">
                <input type="file" name="file">
                <br>
                <button type="submit" class="btn btn-primary">Ok</button>
            </form>
            <br>
        </#if>
    </div>
</@main.renderWith>