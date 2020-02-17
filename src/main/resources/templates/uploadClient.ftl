<#import "parts/common.ftl" as c>

<@c.page>
    <div class="container-center">
    <form method="post" action="/upload/${client.id}" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="${client.name}"/>
        <input type="text" name="address" placeholder="${client.address}"/>
        <input type="text" name="mail" placeholder="${client.mail!''}"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <br/>
        <button type="submit" value="Добавить">Изменить</button>
        <#--        <input type="file" name="file">-->
    </form>
</@c.page>