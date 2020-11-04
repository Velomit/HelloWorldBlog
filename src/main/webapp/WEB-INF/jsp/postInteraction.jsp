<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <form:form method="post" modelAttribute="post">
        <form:hidden path="id" />
        <fieldset class="form-group">
            <form:label path="title">Title</form:label>
            <form:input path="title" type="text" class="form-control" required="required" />
            <form:errors path="title" cssClass="text-warning" />
        </fieldset>

        <fieldset class="form-group">
            <form:label path="description">Description</form:label>
            <form:input path="description" type="text" class="form-control" required="required" />
            <form:errors path="description" cssClass="text-warning" />
        </fieldset>

        <fieldset class="form-group">
            <form:label path="text">Text</form:label>
            <form:input path="text" type="text" class="form-control" required="required" />
            <form:errors path="text" cssClass="text-warning" />
        </fieldset>

        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>
<%@ include file="common/footer.jspf" %>