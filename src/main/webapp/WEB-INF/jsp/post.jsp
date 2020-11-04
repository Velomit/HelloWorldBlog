<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>${post.title}</h1>
    <hr class="my-4">
    <p class= "lead">${post.description}</p>
    <p class= "lead"> by
        <c:forEach items="${authors}" var="author">
        ${author.lastName} ${author.firstName};
        </c:forEach>
    </p>
    <p>${post.text}</p>

    <a type="button" class="btn btn-info" href="/update-post?id=${post.id}">Update</a>
    <a type="button" class="btn btn-danger" href="/delete-post?id=${post.id}">Delete</a>
</div>

<%@ include file="common/footer.jspf" %>