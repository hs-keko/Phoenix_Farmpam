<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="tmp" items="${commentList }">
	<c:choose>
		<c:when test="${tmp.deleted eq 'yes' }">
			<li>삭제된 댓글 입니다.</li>
		</c:when>
		<c:otherwise>
			<c:if test="${tmp.comments_idx eq tmp.comments_group}">
				<li id="reli${tmp.comments_idx }" class="page-${pageNum }">
			</c:if>
			<c:if test="${tmp.comments_idx ne tmp.comments_group }">
				<li id="reli${tmp.comments_idx }" class="page-${pageNum }" style="padding-left:50px;" >
					<svg class="reply-icon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-return-right" viewBox="0 0 16 16">
 							<path fill-rule="evenodd" d="M1.5 1.5A.5.5 0 0 0 1 2v4.8a2.5 2.5 0 0 0 2.5 2.5h9.793l-3.347 3.346a.5.5 0 0 0 .708.708l4.2-4.2a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 8.3H3.5A1.5 1.5 0 0 1 2 6.8V2a.5.5 0 0 0-.5-.5z"/>
					</svg>
			</c:if>
					<dl>
						<dt>
							<c:if test="${ empty tmp.users_profile }">
								<svg class="profile-image" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
								  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
								  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
								</svg>
							</c:if>
							<c:if test="${not empty tmp.users_profile }">
								<img class="profile-image" src="${pageContext.request.contextPath}${tmp.users_profile }"/>
							</c:if>
							<span>${tmp.comments_writer }</span>
							<c:if test="${tmp.comments_idx ne tmp.comments_group }">
								@<i>${tmp.comments_target_id }</i>
							</c:if>
							<span>${tmp.comments_regdate }</span>
							<a data-num="${tmp.comments_idx }" href="javascript:" class="reply-link">답글</a>
							<c:if test="${ (users_email ne null) and (tmp.comments_writer eq users_email) }">
								<a data-num="${tmp.comments_idx }" class="update-link" href="javascript:">수정</a>
								<a data-num="${tmp.comments_idx }" class="delete-link" href="javascript:">삭제</a>
							</c:if>
						</dt>
						<dd>
							<pre id="pre${tmp.comments_idx }">${tmp.comments_content }</pre>						
						</dd>
					</dl>
					<form id="reForm${tmp.comments_idx }" class="animate__animated comment-form re-insert-form" action="comment_insert.do" method="post">
						<input type="hidden" name="comments_ref_group" value="${tmp.comments_idx }"/>
						<input type="hidden" name="comments_target_id" value="${tmp.comments_writer }"/>
						<input type="hidden" name="comments_group" value="${tmp.comments_group }"/>
						<textarea name="content"></textarea>
						<button type="submit">등록</button>
					</form>
				<c:if test="${tmp.comments_writer eq users_email }">
					<form id="updateForm${tmp.comments_idx }" class="comment-form update-form" action="comment_update.do" method="post">
						<input type="hidden" name="comments_idx" value="${tmp.comments_idx }" />
						<textarea name="content">${tmp.comments_content }</textarea>
						<button type="submit">수정</button>
					</form>
				</c:if>
				</li>		
		</c:otherwise>
	</c:choose>
</c:forEach>