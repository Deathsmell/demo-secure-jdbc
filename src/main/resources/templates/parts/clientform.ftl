<#macro clientform>
    <div class="accordion" id="accordionExample">
        <div class="card">
            <div class="card-header" id="headingOne">
                <h5 class="mb-0 text-center">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                        Форма поиска
                    </button>
                </h5>
            </div>
<#--            -->
            <div id="collapseOne" class="collapse  <#--      добавить сюда ${isSearch}      --> " aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">
                    <div class="container-center">
                        <form method="get" action="/index">
                            <input type="text" name="name" placeholder="Введите название организации">
                            <button type="submit">Найти</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="headingTwo">
                <h6 class="mb-0 text-center">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Форма добавления
                    </button>
                </h6>
            </div>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                <div class="card-body">
                    <div class="container-center">
                        <form method="post" action="/index" enctype="multipart/form-data">
                            <input type="text" name="name" placeholder="Введите название организации"/>
                            <input type="text" name="address" placeholder="Введите адрес"/>
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <br/>
                            <button type="submit" value="Добавить">Добавить</button>
                            <input type="file" name="file">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <#--<div class="card">
            <div class="card-header" id="headingThree">
                <h6 class="mb-0 text-center" >
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        #пусто#
                    </button>
                </h6>
            </div>
            <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                <div class="card-body">
                    &lt;#&ndash;         Здесь могла бы быть ваша реклама           &ndash;&gt;
                </div>
            </div>
        </div>-->
    </div>
</#macro>