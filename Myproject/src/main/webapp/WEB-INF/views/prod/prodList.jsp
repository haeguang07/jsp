<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<style>
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
<section class="py-5">
	<header class="bg-dark py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<h1 class="display-4 fw-bolder">예담 커피</h1>
				<p class="lead fw-normal text-white-50 mb-0">커피 판매합니다</p>
			</div>
		</div>
	</header>
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<c:forEach var="prod" items="${list }">
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Sale badge-->
							<c:set var="dc" value="${prod.prodDc }" />
							<c:if test="${dc>0}">
								<div class="badge bg-dark text-white position-absolute"
									style="top: 0.5rem; right: 0.5rem">Sale</div>
							</c:if>
							<!-- Product image-->

							<img class="card-img-top" src="images/${prod.prodImg }" alt="..." />
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder">
										<a href="productMainForm.do?pid=${prod.prodId }">${prod.prodName }</a>
									</h5>
									<!-- Product reviews-->
									<div
										class="d-flex justify-content-center small text-warning mb-2">
										<c:forEach begin="1" end="${prod.prodStar }">
											<div class="bi-star-fill"></div>
										</c:forEach>
									</div>
									<!-- Product price-->

									<c:set var="price" value="${prod.prodPrice }" />
									<c:choose>
										<c:when test="${dc!=0}">
											<span class="text-muted text-decoration-line-through">${price }</span>
											<f:parseNumber  var= "result" integerOnly= "true" value="${price *(1- dc) }"/>
											${result }원
										</c:when>
										<c:otherwise>
										
											${prod.prodPrice }원
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto" href="#">카트에 추가</a>
								</div>
							</div>
						</div>
					</div>

				</c:forEach>
			</div>
		<div class="center">
			<div class="pagination">
				<c:if test="${pageInfo.prev }">
					<a href="productListForm.do?page=${pageInfo.startPage-1 }"> 이전페이지</a>
				</c:if>
				<c:forEach var="i" begin="${pageInfo.startPage}"
					end="${pageInfo.endPage}">
					<a class="${i==pageInfo.pageNum ? 'active':'' }"
						href="productListForm.do?page=${i}">${i} </a>
				</c:forEach>
				<c:if test="${pageInfo.next }">
					<a href="productListForm.do?page=${pageInfo.endPage+1 }"> 다음페이지</a>
				</c:if>
			</div>
		</div>
		</div>
	</section>
	</section>