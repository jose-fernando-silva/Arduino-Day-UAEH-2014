<table class="ajax">
    <thead>
        <tr>
            <g:sortableColumn property="id" title="${message(code: 'user.id.label', default: 'Id')}" />
            <g:sortableColumn property="nombres" title="${message(code: 'user.name.label', default: 'Nombres')}" />
       </tr>
    </thead>
    <tbody>
    <g:each in="${userInstanceList}" status="i" var="userInstance">
        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
            <td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "id")}</g:link></td>
            <td>${fieldValue(bean: userInstance, field: "nombres")}</td>
         </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination">
    <g:paginate total="${userInstanceTotal}" />
</div>