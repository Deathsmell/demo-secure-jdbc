<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

    <div>
        <h1>List clients</h1>
    </div>
    <#if clients??>

        <#list clients as client>
            <div>
                <b>${client.id}</b>
                <span>${client.name}</span>
                <i>${client.address}</i>
                <th><a href="/delete/${client.id}">delete</a></th>
            </div>
        <#else>
            No client
        </#list>

    </#if>
    <div>
        <form method="post" action="/index">
            <input type="text" name="name" placeholder="Введите название организации"/>
            <input type="text" name="address" placeholder="Введите адрес"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Добавить</button>
        </form>
    </div>
    <form method="get" action="/index">
        <input type="text" name="name" placeholder="Введите название организации">
        <button type="submit">Найти</button>
    </form>
    <div>
        <@l.logout/>
        <a href="/user">
            <button type="button">User list</button>
        </a>
    </div>

</@c.page>