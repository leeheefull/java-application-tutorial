package kr.ac.hs.se.controller;

import kr.ac.hs.se.menu.BusinessCardMenu;
import kr.ac.hs.se.service.BusinessCardService;
import kr.ac.hs.se.view.BusinessCardView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BusinessCardController {

    private final BusinessCardService businessCardService = new BusinessCardService();
    private final BusinessCardView businessCardView = new BusinessCardView();

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
                        lookUp();
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

    private void search(BufferedReader br) throws IOException {
        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.SEARCH.getTitle());

        businessCardView.showInput("검색할 번호");
        int cardNo = Integer.parseInt(br.readLine());

        businessCardView.showSearchedBusinessCard(businessCardService.searchBusinessCard(cardNo));
    }

    private void create(BufferedReader br) throws IOException {
        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.CREATE.getTitle());
        String personName = inputName(br);
        String phoneNo = inputPhoneNo(br);
        String companyName = inputCompanyName(br);

        businessCardService.createBusinessCard(personName, phoneNo, companyName);
        businessCardView.showCompleteInsert();
    }

    private void lookUp() {
        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.LOOKUP.getTitle());
        businessCardView.showBusinessCards(businessCardService.getBusinessCards());
    }

    private void update(BufferedReader br) throws IOException {
        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.UPDATE.getTitle());

        businessCardView.showInput("수정할 번호");
        int cardNo = Integer.parseInt(br.readLine());

        String personName = inputName(br);
        String phoneNo = inputPhoneNo(br);
        String companyName = inputCompanyName(br);

        businessCardService.updateBusinessCard(cardNo, personName, phoneNo, companyName);
    }

    private void delete(BufferedReader br) throws IOException {
        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.DELETE.getTitle());

        businessCardView.showInput("삭제할 번호");
        int cardNo = Integer.parseInt(br.readLine());

        businessCardService.removeBusinessCard(cardNo);
    }

    private String inputName(BufferedReader br) throws IOException {
        businessCardView.showInput("이름");
        return br.readLine();
    }

    private String inputPhoneNo(BufferedReader br) throws IOException {
        businessCardView.showInput("전화번호");
        return br.readLine();
    }

    private String inputCompanyName(BufferedReader br) throws IOException {
        businessCardView.showInput("회사");
        return br.readLine();
    }
}
