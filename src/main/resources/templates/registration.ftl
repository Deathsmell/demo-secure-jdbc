<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <h1>Add new user</h1>
    <#if message??>
        ${message}
    </#if>
    <@l.login "/registration"/>
    <a href="/login"><button type="button">Back</button> </a>
</@c.page>