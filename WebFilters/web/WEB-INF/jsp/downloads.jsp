<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple design</title>

        <%@include file="/WEB-INF/jspf/styles.jspf" %>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>

        <div class="container">
            <h1>Hello Downloads!</h1>

            <div class="row">
                <div class="col-md-9">
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Timestamp</th>
                                <th>Length</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${fileList}" var="file">
                                <tr>
                                    <td>${file.id}</td>
                                    <td>${file.name}</td>
                                    <td><fmt:formatDate value="${file.timestamp}" pattern="dd.MM.yyyy (hh:mm:ss)" /></td>
                            <td>${file.length}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="4" align="right">
                                    Total files: ${fileList.size()}
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Upload new file</h3>
                        </div>
                        <div class="panel-body">
                            <form class="form" method="post" action="${pageContext.servletContext.contextPath}/upload" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="control-label" for="fileUpload">Select file to upload</label>
                                    <input id="fileUpload" name="upload" type="file" />
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-sm btn-primary"><i class="fa fa-upload"></i> Upload file</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="/WEB-INF/jspf/scripts.jspf" %>
    </body>
</html>
