<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <c:forEach items="${posts}" var="post">
        <div class="jumbotron">
            <h1 class="display-7">${post.title}</h1>
            <hr class="my-4">
            <p>${post.description}</p>
            <p class="lead">
                <a class="btn btn-primary btn-lg" href="/post?id=${post.id}" role="button">Read</a>
            </p>
        </div>
    </c:forEach>
</div>

<%@ include file="common/footer.jspf" %>