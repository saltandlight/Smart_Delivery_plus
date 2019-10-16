<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<div class="row">   
<div class="col-lg-3">
		<section>
			<c:choose>
				<c:when test="${navi == null}">
					<jsp:include page="navi.jsp"></jsp:include>
				</c:when>
				<c:otherwise>

					<jsp:include page="${navi}.jsp"></jsp:include>
				</c:otherwise>
			</c:choose>
		</section>
</div>
<div class="col-lg-9">
		<section>
			<c:choose>
				<c:when test="${center == null}">
					<jsp:include page="center.jsp"></jsp:include>
				</c:when>
				<c:otherwise>

					<jsp:include page="${center}.jsp"></jsp:include>
				</c:otherwise>
			</c:choose>
		</section>
	</div>
</div>
<div class="col-lg-9">
		<section>
			<c:choose>
				<c:when test="${footer == null}">
					<jsp:include page="footer.jsp"></jsp:include>
				</c:when>
				<c:otherwise>

					<jsp:include page="${footer}.jsp"></jsp:include>
				</c:otherwise>
			</c:choose>
		</section>
	</div>
</div>