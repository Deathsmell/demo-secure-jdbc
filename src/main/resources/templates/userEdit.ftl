<#import "parts/common.ftl" as c>

<@c.page>
    <h1>User editor</h1>

    <form method="post" action="/user">
        <label>
            <input type="text" name="username" value="${user.username}">
        </label>
        <#list roles as role>
            <div>
                <label>
                    <input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")}>${role}
                </label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userID">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>
</@c.page>