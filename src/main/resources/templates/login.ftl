<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <h1>Login page</h1>
    <@l.login "/login" />
    <a href="/registration"><button type="button">Registration</button> </a>
</@c.page>