package kr.ac.hs.se.controller;

import kr.ac.hs.se.menu.BusinessCardMenu;
import kr.ac.hs.se.service.BusinessCardService;
import kr.ac.hs.se.view.BusinessCardView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static kr.ac.hs.se.menu.PageMenu.*;

public class BusinessCardController {

    private static BusinessCardController businessCardController;
    private final BusinessCardService businessCardService = BusinessCardService.getInstance();
    private final BusinessCardView businessCardView = BusinessCardView.getInstance();

    public static BusinessCardController getInstance() {
        if (businessCardController == null) {
            businessCardController = new BusinessCardController();
        }
        return businessCardController;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                BusinessCardMenu menu = inputMenu(br);
                switch (menu) {
                    case SEARCH:
                        search(br);
                        break;
                    case CREATE:
                        create(br);
                        break;
                    case LOOKUP:
                        lookUp(br);
                        break;
                    case UPDATE:
                        update(br);
                        break;
                    case DELETE:
                        delete(br);
                        break;
                    case END:
                        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.END.getTitle());
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BusinessCardMenu inputMenu(BufferedReader br) throws IOException {
        businessCardView.showMenu();
        return BusinessCardMenu.of(br.readLine());
    }

    private String inputPageMenu(BufferedReader br) throws IOException {
        businessCardView.showPageMenu();
        return br.readLine();
    }

    private void search(BufferedReader br) throws IOException {
        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.SEARCH.getTitle());
        int cardNo = inputInteger(br, "검색할 번호");
        businessCardView.showSearchedBusinessCard(businessCardService.searchBusinessCard(cardNo));
    }

    private void create(BufferedReader br) throws IOException {
        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.CREATE.getTitle());
        String personName = inputString(br, "이름");
        String phoneNo = inputString(br, "전화번호");
        String companyName = inputString(br, "회사");

        businessCardService.createBusinessCard(personName, phoneNo, companyName);
        businessCardView.showCompleteInsert();
    }

    private void lookUp(BufferedReader br) throws IOException {
        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.LOOKUP.getTitle());
        int page = 1;
        int num = inputInteger(br, "페이지 당 글의 수");

        out:
        while (true) {
            businessCardView.showBusinessCards(businessCardService.getBusinessCardByPage(page, num));
            String control = inputPageMenu(br);
            switch (control) {
                case PREVIOUS:
                    page--;
                    break;
                case NEXT:
                    page++;
                    break;
                case BACK:
                    break out;
            }
        }
    }

    private void update(BufferedReader br) throws IOException {
        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.UPDATE.getTitle());
        int cardNo = inputInteger(br, "수정할 번호");

        String personName = inputString(br, "이름");
        String phoneNo = inputString(br, "전화번호");
        String companyName = inputString(br, "회사");

        businessCardService.updateBusinessCard(cardNo, personName, phoneNo, companyName);
    }

    private void delete(BufferedReader br) throws IOException {
        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.DELETE.getTitle());
        int cardNo = inputInteger(br, "삭제할 번호");
        businessCardService.removeBusinessCard(cardNo);
    }

    private String inputString(BufferedReader br, String input) throws IOException {
        businessCardView.showInput(input);
        return br.readLine();
    }

    private int inputInteger(BufferedReader br, String input) throws IOException {
        businessCardView.showInput(input);
        return Integer.parseInt(br.readLine());
    }
}
