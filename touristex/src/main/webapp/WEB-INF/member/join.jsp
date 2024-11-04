<%--
  Created by IntelliJ IDEA.
  User: smd99
  Date: 24. 10. 23.
  Time: 오후 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title> 회원가입 | 투어리스트인투어 </title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="/resources/css/common.css">
    <script src="/resources/js/jquery-1.11.3.min.js"></script>
    <script src="/resources/js/common.js"></script>
    <script src="/resources/js/jquery.smooth-scroll.min.js"></script>
    <!--[if lte IE 9]>
    <script src="/resources/js/html5shiv.js"></script>
    <script src="/resources/js/placeholders.min.js"></script>
    <![endif]-->
</head>

<body>
<ul class="skipnavi">
    <li><a href="#container">본문내용</a></li>
</ul>
<!-- wrap -->
<div id="wrap">

    <header id="header">
        <div class="header_area box_inner clear">
            <h1><a href="index.html">Tourist in tour</a></h1>
            <p class="openMOgnb"><a href="#"><b class="hdd">메뉴열기</b> <span></span><span></span><span></span></a></p>
            <!-- header_cont -->
            <div class="header_cont">
                <ul class="util clear">
                    <li><a href="login.html">로그인</a></li>
                    <li><a href="javascript:;">회원가입</a></li>
                </ul>
                <nav>
                    <ul class="gnb clear">
                        <li><a href="javascript:;" class="openAll1">여행정보</a>

                            <div class="gnb_depth gnb_depth2_1">
                                <ul class="submenu_list">
                                    <li><a href="javascript:;">국내</a></li>
                                    <li><a href="javascript:;">해외</a></li>
                                </ul>
                            </div>
                        </li>
                        <li><a href="javascript:;" class="openAll2">고객센터</a>
                            <div class="gnb_depth gnb_depth2_2">
                                <ul class="submenu_list">
                                    <li><a href="notice_list.html">공지사항</a></li>
                                    <li><a href="javascript:;">문의하기</a></li>
                                </ul>
                            </div>
                        </li>
                        <li><a href="javascript:;" class="openAll3">상품투어</a>
                            <div class="gnb_depth gnb_depth2_3">
                                <ul class="submenu_list">
                                    <li><a href="program.html">프로그램 소개</a></li>
                                    <li><a href="javascript:;">여행자료</a></li>
                                </ul>
                            </div>
                        </li>
                        <li><a href="javascript:;" class="openAll4">티켓/가이드</a>
                            <div class="gnb_depth gnb_depth2_4">
                                <ul class="submenu_list">
                                    <li><a href="javascript:;">항공</a></li>
                                    <li><a href="javascript:;">호텔</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </nav>
                <p class="closePop"><a href="javascript:;">닫기</a></p>
            </div>
            <!-- //header_cont -->
        </div>
    </header>

    <div id="container">
        <!-- location_area -->
        <div class="location_area member">
            <div class="box_inner">
                <h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
                <p class="location">MEMBER <span class="path">/</span> 회원가입</p>
                <ul class="page_menu clear">
                    <li><a href="javascript:;" class="on">회원가입</a></li>
                </ul>
            </div>
        </div>
        <!-- //location_area -->

        <!-- bodytext_area -->
        <div class="bodytext_area box_inner">
            <!-- appForm -->
            <form action="/member/join" class="appForm" method="post">
                <fieldset>
                    <legend>상담문의 입력 양식</legend>
                    <p class="info_pilsoo pilsoo_item">필수입력</p>
                    <ul class="app_list">
                        <li class="clear">
                            <label for="email_lbl" class="tit_lbl pilsoo_item">이메일</label>
                            <div class="app_content email_area">
                                <input type="text" class="w160" id="email_lbl" name="email1" title="이메일 주소" />
                                <span class="ico_space">@</span>
                                <input type="text" class="w160" name="email2" title="이메일 제공업체 입력" />
                                <div class="select_common">
                                    <select title="이메일 제공업체 목록">
                                        <option value="">직접입력</option>
                                        <option value="">naver.com</option>
                                        <option value="">hanmail.net</option>
                                    </select>
                                </div>
                            </div>
                        </li>
                        <li class="clear">
                            <label for="name_lbl" class="tit_lbl pilsoo_item">작성자명</label>
                            <div class="app_content"><input type="text" class="w100p" id="name_lbl" name="name" placeholder="이름을 입력해주세요"/></div>
                        </li>
                        <li class="clear">
                            <label for="pwd_lbl" class="tit_lbl pilsoo_item">비밀번호</label>
                            <div class="app_content"><input type="password" class="w100p" id="pwd_lbl" name="pwd1" placeholder="비밀번호를 입력해주세요"/></div>
                        </li>
                        <li class="clear">
                            <label for="pwd2_lbl" class="tit_lbl pilsoo_item">비밀번호 확인</label>
                            <div class="app_content"><input type="password" class="w100p" id="pwd2_lbl" name="pwd2" placeholder="비밀번호를 다시 한번 입력해주세요"/></div>
                        </li>
                        <li class="clear">
                            <label for="phone_lbl" class="tit_lbl pilsoo_item">연락처</label>
                            <div class="app_content"><input type="tel" class="w100p" id="phone_lbl" name="phone" placeholder="휴대폰”-”없이 숫자만 입력하세요"/></div>
                        </li>
                        <li class="clear">
                            <span class="tit_lbl">성별</span>
                            <div class="app_content radio_area">
                                <input type="radio" class="css-radio" id="mmm_lbl" name="gender" value="M"><label for="mmm_lbl">남</label>
                                <input type="radio" class="css-radio" id="www_lbl" name="gender" value="F"><label for="www_lbl">여</label>
                            </div>
                        </li>
                        <li class="clear">
                            <span class="tit_lbl">개인정보 활용동의</span>
                            <div class="app_content checkbox_area">
                                <input type="checkbox" class="css-checkbox" id="agree_lbl" name="agree" value="true"><label for="agree_lbl">동의함</label>
                            </div>
                        </li>
                        <li class="clear">
                            <label for="content_lbl" class="tit_lbl">문의내용</label>
                            <div class="app_content"><textarea id="content_lbl" class="w100p" placeholder="간단한 상담 요청 사항을 남겨주시면 보다 상세한 상담이 가능합니다.
전화 상담 희망시 기재 부탁드립니다."></textarea></div>
                        </li>
                    </ul>
                    <p class="btn_line">
                        <button type="submit" class="btn_baseColor">등록</button>
                    </p>

                </fieldset>
            </form>
            <!-- //appForm -->

        </div>
        <!-- //bodytext_area -->

    </div>
    <!-- //container -->

    <footer>
        <div class="foot_area box_inner">
            <ul class="foot_list clear">
                <li><a href="javascript;">이용약관</a></li>
                <li><a href="javascript;">개인정보취급방침</a></li>
            </ul>
            <h2>투어리스트인투어</h2>
            <p class="addr">서울특별시 종로구 혜화동 9길 청운빌딩 5층 <span class="gubun">/</span>
                <span class="br_line">대표전화 <span class="space0">02-1234-5678</span> <span class="gubun">/</span>
					<span class="br_line">E-mail : <span class="space0"> titour@touristintour.com</span></span>
				</span>
            </p>
            <p class="copy box_inner">Copyright(c) TouristInTour all right reserved</p>
            <ul class="snslink clear">
                <li><a href="javascript:;">blog</a></li>
                <li><a href="javascript:;">facebook</a></li>
                <li><a href="javascript:;">instargram</a></li>
            </ul>
        </div>
    </footer>

</div>
<!-- //wrap -->

<h2 class="hdd">빠른 링크 : 전화 문의, 카카오톡, 오시는 길, 꼭대기로</h2>
<div class="quick_area">
    <ul class="quick_list">
        <li><a href="tel:010-7184-4403"><h3>전화 문의</h3><p>010-1234-5678</p></a></li>
        <li><a href="javascript:;"><h3>카카오톡 <em>상담</em></h3><p>1:1상담</p></a></li>
        <li><a href="javascript:;"><h3 class="to_contact">오시는 길</h3></a></li>
    </ul>
    <p class="to_top"><a href="#layout0" class="s_point">TOP</a></p>
</div>

</body>
</html>

