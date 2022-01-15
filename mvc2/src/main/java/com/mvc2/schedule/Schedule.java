package com.mvc2.schedule;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.basic.service.MailService;

@EnableScheduling
@Configuration 
public class Schedule {

	@Autowired
	private MailService mailService;
	
	// 초 분 시 일 월 요일 연도(생략가능)
	@Scheduled(cron = "0 35 18 * * *") 
	public void batch() {
		System.out.println("Mail Schedule Start");
		
		String subject = "이메일 테스트입니다.";
		String contents = "<section style='width:100%25; margin-top:30px; text-align: center;'>\n" + 
						"		<div style='width:1200px; margin:0 auto;'>\n" + 
						"			<h1>이메일 테스트입니다.</h1>\n" + 
						"			<a style='border:1px solid #ff2d60; display:inline-block; color:#ff2d60; padding:8px 20px; text-align:center; font-size:15px; margin-top:10px; text-decoration:none;' href='http://127.0.0.1:8080/bbs'>홈으로</a>\n" + 
						"		</div>\n" + 
						"	</section>";
		String[] receiverList = {"dhtkak14@gmail.com"};
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("subject", subject);
		param.put("contents", contents);
		param.put("receiverList", receiverList);
		mailService.sendNaver(param);
	}
	
	
	/*
		String subject = "(광고) 추운 몸을 녹여줄 포근한 교보 혜택!";
		String contents = "<table align=\"center\" width=\"700\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" + 
				"		<tbody>\n" + 
				"			<tr>\n" + 
				"				<td width=\"700\">\n" + 
				"					<map name=\"Map\">\n" + 
				"						<area target=\"_blank\" shape=\"rect\" href=\"http://ems1.kyobobook.co.kr/5I-125549I-45916966I-4goaSoZE-8zPqrCF-1281441I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7guCbD-72017D-7vCCZD-7vBuCGuPBbD-6pzgI-3\" name=\"AREA127967\" coords=\"0,0,173,99\" alt=\"인터넷&amp;모바일교보문고 바로 찾는 바로드림\">\n" + 
				"						<area target=\"_blank\" shape=\"rect\" href=\"http://ems1.kyobobook.co.kr/8I-125549I-45916966I-4goaSoZE-8zPqrCF-1281442I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7guCbD-72016D-7EPHPuBaD-7160323I-5HCHzhCgD-6pzgI-3\" name=\"AREA127968\" coords=\"175,0,348,99\" alt=\"내 손안의 서점 모바일교보문고\">\n" + 
				"						<area target=\"_blank\" shape=\"rect\" href=\"http://ems1.kyobobook.co.kr/5I-125549I-45916966I-4goaSoZE-8zPqrCF-1281443I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7bPbvPuD-7NPbFPHPmShRUvD-6aBmF-3zUvsBEPF-1RPucSoPnSzhI-3\" name=\"AREA127969\" coords=\"350,0,522,99\" alt=\"빠르고, 깨끗하고, 안전하게 프리미엄 배송\">\n" + 
				"						<area target=\"_blank\" shape=\"rect\" href=\"http://ems1.kyobobook.co.kr/9I-125549I-45916966I-4goaSoZE-8zPqrCF-1281444I-4ehhgE-8D-7D-7zBbD-6ZACvCvCCZD-6oCD-6ZuD-7zvDPvD-7zBboaUvD-7zBboaUvNBSHD-6SHZI-3\" name=\"AREA127970\" coords=\"524,0,699,99\" alt=\"한 달 3권 월 9,900원 회원제 서비스 sam\">\n" + 
				"					</map>\n" + 
				"					<table width=\"700\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" + 
				"				        <tbody>\n" + 
				"				        	<tr>\n" + 
				"				        		<td>\n" + 
				"				        			<table width=\"700\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" + 
				"				          				<tbody>\n" + 
				"				          					<tr><td align=\"left\" colspan=\"9\"><a href=\"http://ems1.kyobobook.co.kr/3I-125549I-45916966I-4goaSoZE-8zPqrCF-1281421I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuI-3\" name=\"ANCHOR127947\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/logo_kyobo_header.gif\" alt=\"교보문고\" border=\"0\" loading=\"lazy\"></a></td></tr>\n" + 
				"				            				<tr><td><a href=\"http://ems1.kyobobook.co.kr/7I-125549I-45916966I-4goaSoZE-8zPqrCF-1281422I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7SHJPKMCuD-6aBmF-3bBaajvF-1MOtI-3\" name=\"ANCHOR127948\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/menu_categoty_01.gif\" alt=\"국내도서\" border=\"0\" loading=\"lazy\"></a></td><td><a href=\"http://ems1.kyobobook.co.kr/2I-125549I-45916966I-4goaSoZE-8zPqrCF-1281423I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7SHJPKiHED-6aBmF-3bBaajvF-1irjI-3\" name=\"ANCHOR127949\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/menu_categoty_02.gif\" alt=\"외국도서\" border=\"0\" loading=\"lazy\"></a></td><td><a href=\"http://ems1.kyobobook.co.kr/5I-125549I-45916966I-4goaSoZE-8zPqrCF-1281424I-4ehhgE-8D-7D-7JSEShBaD-6ZACvCvCCZD-6oCD-6ZuD-7JSEShBaD-7PvCCZD-7PvCCZNBSHD-6SHZI-3\" name=\"ANCHOR127950\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/menu_categoty_03.gif\" alt=\"eBook\" border=\"0\" loading=\"lazy\"></a></td><td><a href=\"http://ems1.kyobobook.co.kr/2I-125549I-45916966I-4goaSoZE-8zPqrCF-1281425I-4ehhgE-8D-7D-7zBbD-6ZACvCvCCZD-6oCD-6ZuD-7zvDPvD-7zBboaUvD-7zBboaUvNBSHD-6SHZI-3\" name=\"ANCHOR127951\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/menu_categoty_04.gif\" alt=\"sam\" border=\"0\" loading=\"lazy\"></a></td><td><a href=\"http://ems1.kyobobook.co.kr/9I-125549I-45916966I-4goaSoZE-8zPqrCF-1281426I-4ehhgE-8D-7D-7bUzSoD-6ZACvCvCCZD-6oCD-6ZuD-7ehD-7uPoCuJNBSHI-3\" name=\"ANCHOR127952\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/menu_categoty_05.gif\" alt=\"음반\" border=\"0\" loading=\"lazy\"></a></td><td><a href=\"http://ems1.kyobobook.co.kr/5I-125549I-45916966I-4goaSoZE-8zPqrCF-1281427I-4ehhgE-8D-7D-7bUzSoD-6ZACvCvCCZD-6oCD-6ZuD-7ehD-7JcJNBSHI-3\" name=\"ANCHOR127953\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/menu_categoty_06.gif\" alt=\"DVD\" border=\"0\" loading=\"lazy\"></a></td><td><a href=\"http://ems1.kyobobook.co.kr/5I-125549I-45916966I-4goaSoZE-8zPqrCF-1281428I-4ehhgE-8D-7D-7ESmhD-6ZACvCvCCZD-6oCD-6ZuD-7ehD-7ESmhNBSHI-3\" name=\"ANCHOR127954\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/menu_categoty_07.gif\" alt=\"기프트\" border=\"0\" loading=\"lazy\"></a></td><td><a href=\"http://ems1.kyobobook.co.kr/6I-125549I-45916966I-4goaSoZE-8zPqrCF-1281429I-4ehhgE-8D-7D-7UzPJD-6ZACvCvCCZD-6oCD-6ZuD-7SHJPKD-6SHZI-3\" name=\"ANCHOR127955\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/menu_categoty_08.gif\" alt=\"중고장터\" border=\"0\" loading=\"lazy\"></a></td><td><a href=\"http://ems1.kyobobook.co.kr/6I-125549I-45916966I-4goaSoZE-8zPqrCF-1281430I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7vPzhRPaaPurPDD-7vPzhzPaaPuD-6aBmI-3\" name=\"ANCHOR127956\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/menu_categoty_09.gif\" alt=\"베스트\" border=\"0\" loading=\"lazy\"></a></td><td><a href=\"http://ems1.kyobobook.co.kr/8I-125549I-45916966I-4goaSoZE-8zPqrCF-1281431I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7vPzhRPaaPurPDD-7zhPBJAzPaaPuD-6aBmI-3\" name=\"ANCHOR127957\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/menu_categoty_10.gif\" alt=\"스테디\" border=\"0\" loading=\"lazy\"></a></td><td><a href=\"http://ems1.kyobobook.co.kr/6I-125549I-45916966I-4goaSoZE-8zPqrCF-1281432I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7HPDguCJUohD-7HPDsuCJUohLHJPKNBSHD-6aBmI-3\" name=\"ANCHOR127958\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/menu_categoty_11.gif\" alt=\"신상품\" border=\"0\" loading=\"lazy\"></a></td><td><a href=\"http://ems1.kyobobook.co.kr/2I-125549I-45916966I-4goaSoZE-8zPqrCF-1281433I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7uPoCbbgBEPD-7uPoCbbFCCZNBSHD-6aBmI-3\" name=\"ANCHOR127959\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/menu_categoty_12.gif\" alt=\"추천\" border=\"0\" loading=\"lazy\"></a></td></tr>\n" + 
				"										</tbody>\n" + 
				"									</table>\n" + 
				"								</td>\n" + 
				"							</tr>\n" + 
				"							<tr>\n" + 
				"								<td align=\"center\" style=\"padding:15px 0 9px 0;\">\n" + 
				"									<table width=\"700\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#cecece\">\n" + 
				"										<tbody>\n" + 
				"											<tr><td><a href=\"http://ems1.kyobobook.co.kr/6I-125549I-45916966I-4goaSoZE-8zPqrCF-1281434I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7PcPHhtPHPDBaD-7PcPHhxSPDFAsSJD-6aBmF-3PcPHhLJF-187460I-3\" name=\"ANCHOR127960\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/prom/mail/2021/Target/211227/bnG_target_01.jpg\" alt=\"1. KB국민카드 3,500원 즉시할인\" width=\"700\" border=\"0\" loading=\"lazy\"></a></td></tr>\n" + 
				"											<tr><td><a href=\"http://ems1.kyobobook.co.kr/8I-125549I-45916966I-4goaSoZE-8zPqrCF-1281435I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7PcPHhtPHPDBaD-7PcPHhxSPDFAsSJD-6aBmF-3PcPHhLJF-194527C-8oaBzzjvF-1MOtI-3\" name=\"ANCHOR127961\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/prom/mail/2021/Target/211227/bnG_target_02.jpg\" alt=\"2. 문학선물 X 일러스트 플래너\" width=\"700\" border=\"0\" loading=\"lazy\"></a></td></tr>\n" + 
				"											<tr><td><a href=\"http://ems1.kyobobook.co.kr/7I-125549I-45916966I-4goaSoZE-8zPqrCF-1281436I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7PcPHhtPHPDBaD-7PcPHhxSPDFAsSJD-6aBmF-3PcPHhsSJF-144050C-8oaBzzjvF-1MOtC-8stiF-1WI-3\" name=\"ANCHOR127962\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/prom/mail/2021/Target/211227/bnG_target_03.jpg\" alt=\"3. #어린이 #겨울방학 #텀블러백\" width=\"700\" border=\"0\" loading=\"lazy\"></a></td></tr>\n" + 
				"											<tr><td><a href=\"http://ems1.kyobobook.co.kr/7I-125549I-45916966I-4goaSoZE-8zPqrCF-1281437I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7PcPHhD-72021D-7bBzZFBhhaPD-6pzgI-3\" name=\"ANCHOR127963\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/prom/mail/2021/Target/211227/bnG_target_04.jpg\" alt=\"4. #복면책왕 #1대책왕 #우승감사\" width=\"700\" border=\"0\" loading=\"lazy\"></a></td></tr>\n" + 
				"											<tr><td><a href=\"http://ems1.kyobobook.co.kr/6I-125549I-45916966I-4goaSoZE-8zPqrCF-1281438I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7PcPHhtPHPDBaD-7PcPHhxSPDFAsSJD-6aBmF-3PcPHhsSJF-144027C-8oaBzzjvF-1MOtC-8stiF-1WI-3\" name=\"ANCHOR127964\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/prom/mail/2021/Target/211227/bnG_target_05.jpg\" alt=\"5. 교보문고 X 헤나유 디지털 굿즈\" width=\"700\" border=\"0\" loading=\"lazy\"></a></td></tr>\n" + 
				"								            <tr><td><a href=\"http://ems1.kyobobook.co.kr/2I-125549I-45916966I-4goaSoZE-8zPqrCF-1281439I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7PcPHhtPHPDBaD-7PcPHhxSPDFAsSJD-6aBmF-3PcPHhsSJF-143362C-8oaBzzjvF-1MOtI-3\" name=\"ANCHOR127965\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/prom/mail/2021/Target/211227/bnG_target_06.jpg\" alt=\"6. #시그니처향 #신상출시 #차량용\" width=\"700\" border=\"0\" loading=\"lazy\"></a></td></tr>\n" + 
				"								            <tr><td><a href=\"http://ems1.kyobobook.co.kr/7I-125549I-45916966I-4goaSoZE-8zPqrCF-1281440I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7PcPHhtPHPDBaD-7PcPHhxSPDFAsSJD-6aBmF-3PcPHhsSJF-144071C-8oaBzzjvF-1MOtC-8stiF-1WI-3\" name=\"ANCHOR127966\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/prom/mail/2021/Target/211227/bnG_target_07.jpg\" alt=\"7. #홈파티 #집에서외식 #키친크로스\" width=\"700\" border=\"0\" loading=\"lazy\"></a></td></tr>\n" + 
				"										</tbody>\n" + 
				"									</table>\n" + 
				"								</td>\n" + 
				"							</tr>\n" + 
				"							<tr>\n" + 
				"								<td align=\"center\" style=\"padding:0px 0 1px 0;\">\n" + 
				"									<img src=\"http://image.kyobobook.co.kr/ink/images/prom/mail/2016/Target/160204/bnF_01.jpg\" border=\"0\" usemap=\"#Map\" loading=\"lazy\">\n" + 
				"								</td>\n" + 
				"							</tr>\n" + 
				"							<tr>\n" + 
				"								<td style=\"padding:10px 0 0;\">\n" + 
				"									<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" bgcolor=\"#e9e9e9\">\n" + 
				"										<tbody>\n" + 
				"											<tr>\n" + 
				"												<td align=\"center\" width=\"176\"><a href=\"http://ems1.kyobobook.co.kr/5I-125549I-45916966I-4goaSoZE-8zPqrCF-1281445I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuI-3\" name=\"ANCHOR127971\" target=\"_blank\" rel=\"noreferrer noopener\"><img src=\"http://image.kyobobook.co.kr/ink/images/mail/logo_kyobo_footer2.gif\" alt=\"교보문고\" border=\"0\" loading=\"lazy\"></a></td><td style=\"padding:20px 15px 15px 0;font-size:11px;line-height:1.4;font-family:'Dotum',Sans-serif;color:#858585;\">\n" + 
				"													2021년 12월 27일, 고객님의 메일 수신옵션을 확인한 후 보내드리는 발신전용 메일입니다.<br>\n" + 
				"													특정 메일만을 받아보시거나, 더 이상 받지 않으시려면 <a href=\"http://ems1.kyobobook.co.kr/4I-125549I-45916966I-4goaSoZE-8zPqrCF-1281446I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7bAuCCbD-7PbBSatPpPohICubD-6aBmF-3bPbHCF-162015195575C-8PbBSaF-1JehZBZ104F-4HBcPuD-6oCbI-3\" name=\"ANCHOR127972\" style=\"color:#858585;text-decoration:none;\" target=\"_blank\" rel=\"noreferrer noopener\">[수신거부]</a> 버튼을 눌러주세요.<br>\n" + 
				"													(If you don’t want receive this mail anymore, <a href=\"http://ems1.kyobobook.co.kr/9I-125549I-45916966I-4goaSoZE-8zPqrCF-1281447I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7bAuCCbD-7PbBSatPpPohICubD-6aBmF-3bPbHCF-162015195575C-8PbBSaF-1JehZBZ104F-4HBcPuD-6oCbI-3\" name=\"ANCHOR127973\" style=\"color:#858585;text-decoration:underline;\" target=\"_blank\" rel=\"noreferrer noopener\">click here</a>.)<br>\n" + 
				"													저희 교보문고는 방송통신위원회 권고사항에 따라 메일을 제작, 발송하고 있습니다.<br>\n" + 
				"													<br>\n" + 
				"													문의사항은 <a href=\"http://ems1.kyobobook.co.kr/4I-125549I-45916966I-4goaSoZE-8zPqrCF-1281448I-4ehhgE-8D-7D-7DDDD-6ZACvCvCCZD-6oCD-6ZuD-7ozoPHhPuD-7ozfPHhPuNBSHD-6aBmI-3\" name=\"ANCHOR127974\" style=\"color:#858585;text-decoration:underline;\" target=\"_blank\" rel=\"noreferrer noopener\">FAQ</a>를 이용해 주시기 바랍니다. &nbsp; | &nbsp; 고객센터 1544-1900<br>\n" + 
				"													<br>\n" + 
				"													전송자 : 인터넷교보문고 &nbsp; | &nbsp; 대표이사 : 안병현 <br>\n" + 
				"													통신판매신고번호 : 제 653호 &nbsp; | &nbsp; 사업자등록번호 : 102-81-11670<br>\n" + 
				"													주소 : 서울시 종로구 종로 1 (주)교보문고<br>\n" + 
				"												</td>\n" + 
				"											</tr>\n" + 
				"										</tbody>\n" + 
				"									</table>\n" + 
				"								</td>\n" + 
				"							</tr>\n" + 
				"						</tbody>\n" + 
				"					</table>\n" + 
				"			</td></tr>\n" + 
				"		</tbody>\n" + 
				"	</table>";
	 */
}
