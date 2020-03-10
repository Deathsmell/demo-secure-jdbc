<#import "parts/common.ftl" as c>

<@c.page>
    <h1>List of users</h1>
    <#list user as user>
        <div class="card mb-3" style="max-width: 540px;">
            <div class="row no-gutters">
                <div class="col-md-4">
                    <img src="#" class="card-img" alt="#">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h4>Username: ${user.username}</h4>
                        <p class="card-text"> Role:
                            <#list user.roles as role>
                                ${role}<#sep >,
                            </#list>
                        </p>
                        <a href="#" class="btn btn-primary">Редактировать</a>
                    </div>
                </div>
            </div>
        </div>
    </#list>


<#--<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list user as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep >,</#list></td>
            <td><a href="/user/${user.id}">Edit</a></td>
        </tr>
    </#list>
    </tbody>
</table>-->
</@c.page>