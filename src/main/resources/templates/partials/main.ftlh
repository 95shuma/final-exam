<#macro renderWith title="Welcome to Cafe Critic!" scripts=["https://code.jquery.com/jquery-3.4.1.slim.min.js","https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js","https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"] styles=[]>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <title>${title}</title>
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
    </head>
    <body>

    <div class="container">
        <div class="row header-1" style="background-color: #c9e8b7;">
            <div class="col-2">
                <div class="brain">
                    <a href="/" class="btn-1">
                        <i class="fas fa-mug-hot"></i>
                    </a>
                </div>
            </div>
            <div class="col-3">
                <span style="font-size: 3em; color: #3498db">Cafe Critic</span>
            </div>
            <div class="col-4">
                <form action="" method="post">
                    <p><b>Search by name or description</b></p>
                    <div class="search-box">
                        <input class="search-txt" type="text" name="name" placeholder="Name">
                        <button type="submit" class="search-btn"><i class="fas fa-search"></i></button>
                    </div>
                </form>
            </div>
            <#if user??>
                <div class="col-3">
                    <h6>Hello, ${user.name}</h6>
                    <form action="/logout" method="post" id="form-logout" class="flex box-128">
                        <button type="submit" class="flex box-128 logout-button btn btn-light"> Logout </button>
                    </form>
                    <a href="/user/add-place" class="btn btn-primary"><h6> Add new place</h6></a>
                </div>
            <#else>
                <div class="col-3">
                    <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#addUser"><h6> Sign in </h6></button>
                    <a class="flex box-128 btn btn-primary" href="/login"><h6> Login </h6></a>
                </div>
            </#if>
        </div>
        <#nested>

        <!-- Modal -->
        <div class="modal fade" id="addUser" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title text-uppercase" id="exampleModalLabel">Registration</h5>
                    </div>
                    <div class="modal-body">
                        <form id="form-comment" action="" method="post">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input minlength="1" maxlength="20" name="name" type="text" class="form-control" id="name" placeholder="Name">
                                <br>
                                <label for="password">Password</label>
                                <input minlength="1" maxlength="20" name="password" type="password" class="form-control" id="password" placeholder="Password">
                            </div>
                            <button type="submit" class="btn btn-primary  btn-block">Ok</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <#list scripts as scriptSource>
        <script src="${scriptSource}"></script>
    </#list>
    <script>
        $('#myModal').on('shown.bs.modal', function () {
            $('#myInput').trigger('focus')
        })
    </script>
    </body>
    </html>
</#macro>