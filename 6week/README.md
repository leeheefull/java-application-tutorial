# Reservation Program

## 요구사항

* GET (카테고리 목록 구하기): /api/categories
* GET (상품 목록 구하기): /api/displayinfos
* GET (프로모션 목록 구하기): /api/promotions
* GET (카테고리 목록 구하기): /api/displayinfos/{displayId}
* GET (댓글 목록 구하기): /api/displayinfos



## 테이블

![image](https://user-images.githubusercontent.com/58816862/107901372-d680d400-6f86-11eb-806c-87247fedc14c.png)

![image](https://user-images.githubusercontent.com/58816862/107901555-4db66800-6f87-11eb-92d4-62f326ba6a48.png)

![image](https://user-images.githubusercontent.com/58816862/107901592-61fa6500-6f87-11eb-8a1c-e254af0b4a84.png)

![image](https://user-images.githubusercontent.com/58816862/107901620-73437180-6f87-11eb-88f4-e59974fe71c0.png)

![image](https://user-images.githubusercontent.com/58816862/107901638-85bdab00-6f87-11eb-8dd8-80a9cdfd8023.png)

![image](https://user-images.githubusercontent.com/58816862/107901661-99691180-6f87-11eb-85f5-a56c78b8aa76.png)

![image](https://user-images.githubusercontent.com/58816862/107901687-a71e9700-6f87-11eb-8027-a7b9507efbf1.png)

![image](https://user-images.githubusercontent.com/58816862/107901726-c0bfde80-6f87-11eb-927c-8bcf93dd5e7c.png)

![image-20210215121824242](C:\Users\227\AppData\Roaming\Typora\typora-user-images\image-20210215121824242.png)

![image](https://user-images.githubusercontent.com/58816862/107901789-e220ca80-6f87-11eb-9f3b-8197dd84094e.png)



## 실행 화면

> GET (카테고리 목록 구하기): /api/categories

```json
{
    "size": 5,
    "items": [
        {
            "id": 1,
            "name": "전시",
            "count": 10
        },
        {
            "id": 2,
            "name": "뮤지컬",
            "count": 10
        },
        {
            "id": 3,
            "name": "콘서트",
            "count": 16
        },
        {
            "id": 4,
            "name": "클래식",
            "count": 10
        },
        {
            "id": 5,
            "name": "연극",
            "count": 13
        }
    ]
}
```

> GET (상품 목록 구하기): /api/displayinfos

```json
{
    "totalCount": 16,
    "productCount": 4,
    "products": [
        {
            "id": 21,
            "categoryId": 3,
            "displayInfoId": 21,
            "name": "콘서트",
            "description": "5TARDIUM 2018",
            "content": "Surrealistic EDM Festival with Magnificent Stage and Performances. 2 Days, 10 Artists for 5th Anniversary!",
            "event": "",
            "openingHours": "2017년 12월 12일(토) 12PM",
            "placeName": "장소 추후 공개",
            "placeLot": "서울특별시 중구 태평로1가 31",
            "placeStreet": "서울특별시 중구 세종대로 110",
            "tel": "010-3360-7846",
            "homepage": "",
            "email": "",
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0",
            "fileId": 113
        },
        {
            "id": 22,
            "categoryId": 3,
            "displayInfoId": 22,
            "name": "콘서트",
            "description": "노브레인 연말 콘서트 [락이 먼저다]",
            "content": "노브레인 연말 콘서트 2017.12.30.(SAT) 저녁 7시 @롤링홀",
            "event": "",
            "openingHours": "2017.12.30.(SAT) 저녁 7시\n",
            "placeName": "@롤링홀",
            "placeLot": "서울특별시 마포구 서교동 402-22",
            "placeStreet": "서울특별시 마포구 어울마당로 35",
            "tel": "02-322-8487",
            "homepage": "",
            "email": "",
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0",
            "fileId": 115
        },
        {
            "id": 23,
            "categoryId": 3,
            "displayInfoId": 23,
            "name": "콘서트",
            "description": "[크리스마스 살롱콘서트] 재즈 보컬 듀엣 허성&마리아킴",
            "content": "[크리스마스 살롱 콘서트]\n재즈 보컬 듀엣 허성 & 마리아킴\nChristmas Salon Concert:\nJazz Vocalist Duet Sung Huh & Maria Kim\n\n2017년 12월24일 (일) 1회차: 오후 7시 / 2회차: 오후 9시\n강남역 카페 피아노 리브레\n비지정석\n\n크리스마스 이브! 연인과 친구, 가족들과 함께 아늑한 강남역 피아노 리브레에서 감미로운 재즈 살롱 콘서트를 즐기세요. 모두가 즐길 수 있는 재즈 러브송 들과 크리스마스 캐롤을 들려드립니다. 공연을 관람하시는 분께는 피아노 리브레 시그니쳐 샹그리아와 허성/마리아킴의 앨범 한장을 증정해 드립니다.\n",
            "event": "",
            "openingHours": "2017년 12월24일 (일) 1회차: 오후 7시 / 2회차: 오후 9시\n",
            "placeName": "카페 피아노 리브레 강남점\n",
            "placeLot": "서울특별시 강남구 역삼동 818-5 혜진빌딩 2층",
            "placeStreet": "서울특별시 강남구 강남대로96길 20 혜진빌딩",
            "tel": "02-554-9913",
            "homepage": "https://youtu.be/BuaEQSxVR5A",
            "email": "",
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0",
            "fileId": 117
        },
        {
            "id": 24,
            "categoryId": 3,
            "displayInfoId": 24,
            "name": "콘서트",
            "description": "Odd Christmas\n",
            "content": "데미안 라이스도 감탄한 거리의 연주자, 어쿠스틱 혼성 듀오\n오드트리(Odd Tree) 단독콘서트 'Odd Christmas' 개최 @벨로주\n\n이번 'Odd Christmas'에서는 연말을 맞이하여\n크리스마스 캐럴을 포함, 그 동안 선보인 적 없던 다양한 곡을\n오드트리 만의 감성으로 풀어내며 관객들에게 포근하고 아늑한 선물 같은 시간을 선사하고자 합니다.\n\n이번 공연은 오드트리가 관객들에게 드리는 '선물'인 만큼, 선착순 30명에 한하여 1+1로 예매 가능합니다.\n",
            "event": "",
            "openingHours": "2017년 12월 22일(금) 오후 8시",
            "placeName": "망원동 벨로주",
            "placeLot": "서울특별시 마포구 망원동 422-27 메디움빌딩 4층",
            "placeStreet": "서울특별시 마포구 포은로 117 메디움빌딩 4층\n",
            "tel": "02-2644-4315",
            "homepage": "",
            "email": "",
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0",
            "fileId": 119
        }
    ]
}
```

> GET (프로모션 목록 구하기): /api/promotions

```json
{
    "size": 11,
    "items": [
        {
            "id": 1,
            "productId": 1,
            "categoryId": 1,
            "categoryName": "전시",
            "description": "Paper, Present:너를 위한 선물",
            "fileId": 61
        },
        {
            "id": 2,
            "productId": 5,
            "categoryId": 1,
            "categoryName": "전시",
            "description": "알렉산더 지라드전",
            "fileId": 73
        },
        {
            "id": 3,
            "productId": 6,
            "categoryId": 1,
            "categoryName": "전시",
            "description": "캠퍼스 라이프 엑스포",
            "fileId": 78
        },
        {
            "id": 4,
            "productId": 9,
            "categoryId": 1,
            "categoryName": "전시",
            "description": "무민원화전",
            "fileId": 84
        },
        {
            "id": 5,
            "productId": 11,
            "categoryId": 2,
            "categoryName": "뮤지컬",
            "description": "뮤지컬 모래시계",
            "fileId": 90
        },
        {
            "id": 6,
            "productId": 12,
            "categoryId": 2,
            "categoryName": "뮤지컬",
            "description": "뮤지컬 올슉업",
            "fileId": 92
        },
        {
            "id": 7,
            "productId": 18,
            "categoryId": 2,
            "categoryName": "뮤지컬",
            "description": "뮤지컬 - 카라마조프",
            "fileId": 106
        },
        {
            "id": 8,
            "productId": 22,
            "categoryId": 3,
            "categoryName": "콘서트",
            "description": "노브레인 연말 콘서트 [락이 먼저다]",
            "fileId": 115
        },
        {
            "id": 9,
            "productId": 34,
            "categoryId": 4,
            "categoryName": "클래식",
            "description": "카마라타 크리스마스 특집 콘서트\n",
            "fileId": 145
        },
        {
            "id": 10,
            "productId": 41,
            "categoryId": 5,
            "categoryName": "연극",
            "description": "죽여주는이야기",
            "fileId": 165
        },
        {
            "id": 11,
            "productId": 44,
            "categoryId": 5,
            "categoryName": "연극",
            "description": "어바웃 머니\n",
            "fileId": 172
        }
    ]
}
```

> GET (카테고리 목록 구하기): /api/displayinfos/{displayId}

```json
{
    "product": {
        "id": 1,
        "categoryId": 1,
        "displayInfoId": 1,
        "name": "전시",
        "description": "Paper, Present:너를 위한 선물",
        "content": "대림미술관은 오는 12월 7일부터 2018년 5월 27일까지 세계적인 아티스트들의 섬세한 감각과 아날로그적 소재인 종이가 만나 감성적인 매체로 확장되는 과정을 소개하는 전시 〈PAPER, PRESENT: 너를 위한 선물〉을 개최합니다. 이번 전시에서는 다양한 분야에서 활동하고 있는 아티스트들이 종이의 본래적 속성에 집중하여 재료 자체의 순수한 아름다움을 담은 작품들을 일곱 개의 감각적인 공간에서 선보입니다. 바람, 별빛, 햇살과 같은 자연 요소와 기억, 설렘과 같은 감정의 요소를 종이와 결합하여 구성한 공간들은, 자연 현상을 감각적으로 경험하고 아날로그적 정서를 자극하는 매체로서 종이를 경험하게 하며 종이에 감성을 입혀 예술로 만나는 특별한 시간을 선물할 것입니다.",
        "event": "",
        "openingHours": "- 관람시간: 화, 수, 금, 일요일 오전 10시 - 오후 6시 *전시 종료 30분 전 입장 마감됩니다.\n- 야간개관: 목, 토요일 오전 10시 - 저녁 8시 *전시 종료 30분 전 입장 마감됩니다.\n- 휴관안내: 전시 기간 중 매주 월요일 휴무이며, 설 연휴인 2018년 2월 15일, 16일 휴관입니다.\n12월 25일 (월요일) 정상 운영됩니다.",
        "placeName": "대림미술관",
        "placeLot": "서울특별시 종로구 통의동 35-1",
        "placeStreet": "서울특별시 종로구 자하문로4길 21 대림미술관",
        "tel": "02-6403-9961",
        "homepage": "daelimmuseum.org",
        "email": "",
        "createDate": "2020-03-16 15:49:47.0",
        "modifyDate": "2020-03-16 15:49:47.0",
        "fileId": 61
    },
    "productImages": [
        {
            "productId": 1,
            "productImageId": 2,
            "type": "ma",
            "fileInfoId": 61,
            "fileName": "1_ma_2.png",
            "saveFileName": "img/1_ma_2.png",
            "contentType": "image/png",
            "deleteFlag": 0,
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0"
        }
    ],
    "displayInfoImages": [
        {
            "id": 1,
            "displayInfoId": 1,
            "fileId": 1,
            "fileName": "1_map_1.png",
            "saveFileName": "img_map/1_map_1.png",
            "contentType": "image/png",
            "deleteFlag": 0,
            "createDate": "2020-03-16 15:49:47.0",
            "modifyDate": "2020-03-16 15:49:47.0"
        }
    ],
    "avgScore": 3,
    "productPrices": [
        {
            "id": 3,
            "productId": 1,
            "priceTypeName": "B",
            "price": 2000,
            "discountRate": 50,
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0"
        },
        {
            "id": 2,
            "productId": 1,
            "priceTypeName": "Y",
            "price": 3000,
            "discountRate": 33,
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0"
        },
        {
            "id": 1,
            "productId": 1,
            "priceTypeName": "A",
            "price": 6000,
            "discountRate": 20,
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0"
        }
    ]
}}
```

> GET (댓글 목록 구하기): /api/displayinfos

```json
{
    "totalCount": 15,
    "commentCount": 5,
    "reservationUserComments": [
        {
            "id": 15,
            "productId": 1,
            "reservationInfoId": 15,
            "score": 5,
            "reservationEmail": "dorosi@connect.co.kr",
            "comment": "즐거움!!!",
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0",
            "reservationUserCommentImages": []
        },
        {
            "id": 14,
            "productId": 1,
            "reservationInfoId": 14,
            "score": 5,
            "reservationEmail": "kimkorea@connect.co.kr",
            "comment": "또 가고 싶어.",
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0",
            "reservationUserCommentImages": []
        },
        {
            "id": 13,
            "productId": 1,
            "reservationInfoId": 13,
            "score": 4,
            "reservationEmail": "kimmy@connect.co.kr",
            "comment": "재미남.",
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0",
            "reservationUserCommentImages": []
        },
        {
            "id": 12,
            "productId": 1,
            "reservationInfoId": 12,
            "score": 4,
            "reservationEmail": "kinsujung@connect.co.kr",
            "comment": "좋았음.",
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0",
            "reservationUserCommentImages": []
        },
        {
            "id": 11,
            "productId": 1,
            "reservationInfoId": 11,
            "score": 3,
            "reservationEmail": "kangchan@connect.co.kr",
            "comment": "괜찮았어요.",
            "createDate": "2020-03-16 15:49:48.0",
            "modifyDate": "2020-03-16 15:49:48.0",
            "reservationUserCommentImages": []
        }
    ]
} 
```