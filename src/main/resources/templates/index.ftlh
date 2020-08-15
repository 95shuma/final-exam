<#import "partials/main.ftlh" as main />
<@main.renderWith styles=["css/main.css","https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css","https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"]>
<h2>All places</h2>
    <#if places??>
    <div class="row">
        <#list places as place>
        <div class="col-4">
            <div class="card">
                <img src="http://localhost:7777/image/${place.id}" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${place.place.name}</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
            </div>
        </div>
        </#list>
    </div>
    </#if>
</@main.renderWith>