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
                    case CREATE:
                        create(br);
                        break;
                    case SEARCH:
                        search(br);
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

    private void create(BufferedReader br) throws IOException {
        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.CREATE.getTitle());
        String name = inputName(br);
        String phoneNo = inputPhoneNo(br);
        String companyName = inputCompanyName(br);

        businessCardService.createBusinessCard(name, phoneNo, companyName);
        businessCardView.showCompleteInsert();
    }

    private void search(BufferedReader br) throws IOException {
        businessCardView.showBusinessCardMenuTitle(BusinessCardMenu.SEARCH.getTitle());

        businessCardView.showInput("검색할 이름");
        String name = br.readLine();

        businessCardView.showSearchedBusinessCard(businessCardService.searchBusinessCard(name));
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
