package kr.ac.hs.se.view;

import kr.ac.hs.se.dto.BusinessCard;
import kr.ac.hs.se.menu.BusinessCardMenu;

import java.io.PrintStream;
import java.util.List;

public class BusinessCardView {

    PrintStream out = new PrintStream(System.out);

    public void showMenu() {
        out.println("#### Business Card Management Program ####");
        BusinessCardMenu.selectMenuByName()
                .forEach(out::println);
        out.print(">> ");
    }

    public void showBusinessCardMenuTitle(String businessCardMenuTitle) {
        out.println(businessCardMenuTitle);
    }

    public void showInput(String input) {
        out.print(input + " >> ");
    }

    public void showCompleteInsert() {
        out.println(" -> 새로운 명함이 추가되었습니다.");
    }

    public void showSearchedBusinessCard(BusinessCard searchBusinessCard) {
        out.println("번호\t\t이름\t\t전화번호\t\t\t회사");
        out.println(searchBusinessCard);
    }

    public void showBusinessCards(List<BusinessCard> businessCardList) {
        out.println("번호\t\t이름\t\t전화번호\t\t\t회사");
        businessCardList.forEach(out::println);
    }
}
