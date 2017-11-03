<%@ page pageEncoding="UTF-8"%>
<div class="text-center">
		<ul class="pagination">
		<c:if test="${navi.totalRows gt 0 }">
			<c:choose>
				<c:when test="${navi.pageNo gt 1 }">
					<li><a href="${navi.pageNo -1 }">&lt;</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><span>&lt;</span></li>
				</c:otherwise>
			</c:choose>
			<c:forEach begin="${navi.beginPage }" end="${navi.endPage }" var="num">
				<li class="${navi.pageNo eq num ? 'active' : '' }"><a href="${num }">${num }</a></li>
			</c:forEach>
			<c:choose>
				<c:when test="${navi.pageNo lt navi.totalPages }">
					<li><a href="${navi.pageNo + 1 }">&gt;</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><span>&gt;</span></li>
				</c:otherwise>
			</c:choose>
		</c:if>
	</ul>
</div>
