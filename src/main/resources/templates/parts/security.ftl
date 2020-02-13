<#-- @ftlvariable name="User" type="com.example.demosecurejdbcrest.sweater.entity.User" -->
<!-- Фрагмент для получения данных сессии -->
<#--<#assign  security=JspTaglibs["http://www.springframework.org/security/tags"] />-->
<!-- Определение переменной сессии и приведение ее к bool-->
<#assign
known = Session.SPRING_SECURITY_CONTEXT??

>

<#if known>
    <!-- Сессия существует (вход осуществлен) - получение профиля пользователя -->
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.getAuthorities()?seq_contains("ADMIN")
    isMaster = user.getAuthorities()?seq_contains("MASTER")

    >
<#else >
    <!-- Сессия не существует -->
    <#assign
    name = "unknown"
    isAdmin = false
    >
</#if>