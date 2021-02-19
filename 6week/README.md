# Reservation Program

## 요구사항

* GET (카테고리 목록 구하기): /api/categories
* GET (프로모션 목록 구하기): /api/promotions
* GET (상품 목록 구하기): /api/displayinfos
* GET (카테고리별 상품 목록 구하기): /api/displayinfos/category/{categoryId}
* GET (카테고리별 상품 목록 페이지로 구하기): /api/displayinfos/category/{categoryId}?pagesize={pageSize}&pageno={page}
* GET (상품 세부사항 구하기): /api/displayinfos/{displayId}
* GET (상품 댓글 목록 구하기): /api/comments
* GET (상품별 댓글 목록 구하기): /api/comments/product/{productId}
* GET (상품별 댓글 목록 페이지로 구하기): /api/comments/product/{producrId}?pagesize={pageSize}&pageno={page}



## 테이블

![image](https://user-images.githubusercontent.com/58816862/107901372-d680d400-6f86-11eb-806c-87247fedc14c.png)

![image](https://user-images.githubusercontent.com/58816862/107901555-4db66800-6f87-11eb-92d4-62f326ba6a48.png)

![image](https://user-images.githubusercontent.com/58816862/107901592-61fa6500-6f87-11eb-8a1c-e254af0b4a84.png)

![image](https://user-images.githubusercontent.com/58816862/107901620-73437180-6f87-11eb-88f4-e59974fe71c0.png)

![image](https://user-images.githubusercontent.com/58816862/107901638-85bdab00-6f87-11eb-8dd8-80a9cdfd8023.png)

![image](https://user-images.githubusercontent.com/58816862/107901661-99691180-6f87-11eb-85f5-a56c78b8aa76.png)

![image](https://user-images.githubusercontent.com/58816862/107901687-a71e9700-6f87-11eb-8027-a7b9507efbf1.png)

![image](https://user-images.githubusercontent.com/58816862/107901726-c0bfde80-6f87-11eb-927c-8bcf93dd5e7c.png)

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

> GET (상품 목록 구하기): /api/displayinfos

```json
{
  "totalCount": 59,
  "productCount": 59,
  "products": [
    {
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
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 61
    },
    {
      "id": 2,
      "categoryId": 1,
      "displayInfoId": 2,
      "name": "전시",
      "description": "퀀틴 블레이크",
      "content": "KT&G 상상마당은 20세기 거장시리즈 기획전 일환으로 전 세계적으로 사랑 받는 영국 최고의 일러스트레이터 퀀틴 블레이크(Quentin Blake, 1932-) 전시를 오는 10월 21일(토)부터 내년 2월 20일(화)까지 서울 서교동에 위치한 KT&G 상상마당 갤러리(4,5F)에서 진행한다. 영국 작가 로알드 달(Roald Dahl, 1916-1990)의 아동 소설 『찰리와 초콜릿 공장』 의 원화 작가로 유명한 퀀틴 블레이크는 지난 60여 년간 편안한 그림체와 성인들도 공감할 수 있는 동화들을 꾸준히 발표해왔다. 이번 전시에는 원화 작가에서 나아가 글과 그림을 통한 스토리텔링에 뛰어난 아티스트로서의 면모를 조명하고, 『찰리와 초콜릿 공장』 원화를 비롯한 퀀틴 블레이크의 작품 180여 점과 그의 작업실을 재현해낸 공간을 선보인다.",
      "event": "",
      "openingHours": "- 전시기간: 2017.10.21(토) – 2018.2.20(화)\n- 운영시간: 월-목 am 11:00 - pm 20:00 (19:00 입장마감) / 금-일 am 11:00 - pm 21:00 (20:00 입장마감)\n- 도슨트: 매주 금, 토 14:00, 16:00, 18:00 (3회) / 무료 오디오 가이드 상시 운영",
      "placeName": "KT&G 상상마당 홍대 갤러리 (4, 5F)",
      "placeLot": "서울특별시 마포구 서교동 367-5",
      "placeStreet": "서울특별시 마포구 어울마당로 65 상상마당빌딩",
      "tel": "",
      "homepage": "https://www.sangsangmadang.com/display/detail/435",
      "email": "gallery@sangsangmadang.com",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 63
    },
    {
      "id": 3,
      "categoryId": 1,
      "displayInfoId": 3,
      "name": "전시",
      "description": "ALICE : Into The Rabbit Hole",
      "content": "<반 고흐 인사이드>, <클림트 인사이드>에 이은\n㈜미디어앤아트의 여섯 번째 아트 프로젝트 <ALICE : into the rabbit hole>은\n루이스 캐럴의 <이상한 나라의 앨리스>, <거울나라의 앨리스> 시리즈를\n현대적인 시각으로 표현해낸 새로운 컨셉의 전시입니다.\n\n동화의 새 패러다임을 열며 전 세계인들의 사랑을 받은 불멸의 명작,\n루이스 캐럴의 ‘앨리스’ 시리즈. 그동안은 책, 애니메이션과 영화 등 2차원 세계에서만\n만나볼 수 있던 이 매력적인 동화의 세계관이 현대적인 감각으로 재해석되어\n예쁘고, 즐겁고, 행복해지는 3차원 테마파크 ‘앨리스 랜드’를 만나보세요.\n\n개성 넘치는 일러스트레이션 작가, 감각적인 뮤지션, 키치한 설치작가와\n대중문화를 선도하는 영상크루 등 총 23팀이 ㈜미디어앤아트와 만나\n저마다의 ‘앨리스’와 ‘원더랜드’를 만들어냈습니다.\n\n아티스트 팀들과 협업을 통해 감상의 한계를 뛰어넘어\n앨리스의 기상천외한 모험을 표현해낸 이번 전시는\n딱딱한 일상에서 탈출하는 신나고 즐거운 경험이 될 것입니다.",
      "event": "",
      "openingHours": "- 관람시간: 오전 10시 ~ 오후 7시(입장마감 6시)\n- 월요일 휴관\n- 공휴일 정상개관(크리스마스/신정 정상개관)\n- 관람종료 1시간 전까지 발권 및 입장이 가능합니다.\n- 체험존은 관람종료 15분전에 마감합니다.",
      "placeName": "서울숲 갤러리아포레 The Seouliteum G층 (B2)\n",
      "placeLot": "서울특별시 성동구 성수동1가 685-696",
      "placeStreet": "서울특별시 성동구 왕십리로 85 갤러리아포레\n",
      "tel": "1522-1796",
      "homepage": "http://thealice.co.kr",
      "email": "medianart@mnart.co.kr",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 69
    },
      
		// ...
	    // 중간 생략
      	// ...
      
    {
      "id": 49,
      "categoryId": 5,
      "displayInfoId": 58,
      "name": "연극",
      "description": "수상한흥신소1탄!",
      "content": "특별한 능력을 지닌, 백수고시생! 오상우! 그의 기상천외한 비지니스가 시작된다!!\n",
      "event": "",
      "openingHours": "2017년 12월 1일 ~ 2017년 12월 31일",
      "placeName": "익스트림씨어터1관\n",
      "placeLot": "서울특별시 종로구 동숭동 1-33",
      "placeStreet": "서울특별시 종로구 대학로 128\n",
      "tel": "070-8129-7420\n",
      "homepage": "http://cafe.naver.com/extremeplay2010\n",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 186
    },
    {
      "id": 50,
      "categoryId": 5,
      "displayInfoId": 59,
      "name": "연극",
      "description": "세대공감 음악극 [사는게 꽃같네] ",
      "content": "가까이 있으면서도 무심했던\n우리 가족의 모습을 더 들여다보고 싶게 하는 이야기\n세대공감음악극 [사는게 꽃같네]",
      "event": "",
      "openingHours": "2017.12.20(수)~21.(목)\n16:00, 20:00",
      "placeName": "경성대학교 예노소극장",
      "placeLot": "부산광역시 남구 대연동 산108-5",
      "placeStreet": "부산광역시 남구 수영로 309 경성대학교\n",
      "tel": "1688-8998\n",
      "homepage": "http://mcong.kr",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 188
    }
  ]
}
```

> GET (카테고리별 상품 목록 구하기): /api/displayinfos/category/3

```json
{
  "totalCount": 16,
  "productCount": 16,
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
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
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
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
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
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
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
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 119
    },
    {
      "id": 25,
      "categoryId": 3,
      "displayInfoId": 25,
      "name": "콘서트",
      "description": "뮤지컬 콘서트 '12월의 선물'\n",
      "content": "국내 최초의 뮤지컬 전용극장 샤롯데 씨어터를 운영하며 공연 산업 발전에 기여해 온 롯데엔터테인먼트와\n<지킬앤하이드>, <맨오브라만차>, <드라큘라>등\n대한민국 뮤지컬 시장을 선도해 온 오디컴퍼니가 선사하는 윈터 프로젝트!\n뮤지컬 콘서트 <12월의 선물>\n\n가족, 연인, 친구, 사랑하는 사람들과 함께 하세요.\n2017년 연말, 크리스마스를 환상적인 음악의 향연으로 채워 줄 기적 같은 선물이 찾아옵니다.\n",
      "event": "",
      "openingHours": "- 12월 24일(일) 오후 3시\n- 12월 24일(일) 오후 7시 30분\n- 12월 25일(월) 오후 3시\n- 12월 25일(월) 오후 7시 30분\n",
      "placeName": "8층 롯데콘서트홀",
      "placeLot": "서울특별시 송파구 신천동 29 롯데월드몰",
      "placeStreet": "서울특별시 송파구 올림픽로 300 롯데월드몰",
      "tel": "02-1588-5212",
      "homepage": "",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 121
    },
    {
      "id": 26,
      "categoryId": 3,
      "displayInfoId": 26,
      "name": "콘서트",
      "description": "RAPBEAT SHOW2017\n",
      "content": "차별화된 라인업으로 돌아온 RAPBEAT SHOW！\n색다른 DNA를 가진, Different & Another 출연진을\nRAPBEAT SHOW 2017 with SAMSUNG MUSIC을 통해 선보입니다.\n\n다른 곳에서는 볼 수 없는 아티스트들의 무대를 기대하셔도 좋습니다.\nRAPBEAT SHOW 2017 은 Music & More, Samsung Music과 함께합니다.\n새롭고 더욱 편리해진 Samsung Music은 특별한 음악 경험을 드리는 삼성 갤럭시에 최적화된 음악서비스 입니다.\n\n",
      "event": "",
      "openingHours": "2017.12.17 7PM",
      "placeName": "YES24라이브홀",
      "placeLot": "서울특별시 광진구 광장동 319-33",
      "placeStreet": "서울특별시 광진구 구천면로 20",
      "tel": "02-6012-7135",
      "homepage": "",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 123
    },
    {
      "id": 27,
      "categoryId": 3,
      "displayInfoId": 27,
      "name": "콘서트",
      "description": "러브레터 - 이와이 슌지 시네마 콘서트\n",
      "content": "스톰프뮤직 창립 20주년을 기념하는 아날로그 감성을 깨우는 시간.\n이와이 슈운지 감독의 영화 [러브레터]와 [4월이야기]의 명장면들과\nOST를 라이브 연주로 감상하는 콘서트.\n피아니스트 윤한과 오케스트라가 만들어내는 완성도 높은 사운드를 통해 한층 더 깊어진 울림을 선사할 예정이다.",
      "event": "",
      "openingHours": "2018.03.25 5PM",
      "placeName": "예술의전당 콘서트홀",
      "placeLot": "서울특별시 서초구 서초동 700",
      "placeStreet": "서울특별시 서초구 남부순환로 2406 예술의전당",
      "tel": "02-2658-3546",
      "homepage": "",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 125
    },
    {
      "id": 28,
      "categoryId": 3,
      "displayInfoId": 28,
      "name": "콘서트",
      "description": "거미 콘서트 Feel the Voice Season3\n",
      "content": "9년만의 정규앨범<STROKE>로 돌아온 거미는 1년 내내 공연으로 전국의 관객들을 만나며 음악으로 꽉 채운 한 해를 보냈습니다.\n그리고 이번 연말, 추운 겨울을 따뜻하게 녹여줄 아름다운 무대로 당신에게 잊지 못할 한 해의 마지막 선문하려 합니다.\n당신의 올 해가 그 누구보다 행복했기를 바라며, 힘들었을 누군가에겐 위로가 되어 줄 수 있는 음악으로 올 연말, 당신을 기다리겠습니다.",
      "event": "",
      "openingHours": "- 일자 : 2017년 12월 30일(토) ~ 12월 31일(일)\n- 시간 : 토요일 오후 6시 / 일요일 오후 5시\n",
      "placeName": "세종대학교 대양홀",
      "placeLot": "서울특별시 광진구 군자동 98",
      "placeStreet": "서울특별시 광진구 능동로 209 세종대학교",
      "tel": "02-1644-5690",
      "homepage": "",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 127
    },
    {
      "id": 29,
      "categoryId": 3,
      "displayInfoId": 29,
      "name": "콘서트",
      "description": "2017국카스텐 연말 전국투어[HAPPENING]\n",
      "content": "더 이상의 수식어가 필요없는 국카스텐의 연말 투어 HAPPENING\n",
      "event": "",
      "openingHours": "- 일자 : 2017년 12월 24일(일) ~ 12월 25일(월)\n- 시간 : 일요일 오후 7시 / 월요일 오후 6시",
      "placeName": "서울 잠실실내체육관",
      "placeLot": "서울특별시 송파구 잠실동 10",
      "placeStreet": "서울특별시 송파구 올림픽로 25 서울종합운동장",
      "tel": "1644-5690",
      "homepage": "",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 129
    },
    {
      "id": 29,
      "categoryId": 3,
      "displayInfoId": 30,
      "name": "콘서트",
      "description": "2017국카스텐 연말 전국투어[HAPPENING]\n",
      "content": "더 이상의 수식어가 필요없는 국카스텐의 연말 투어 HAPPENING\n",
      "event": "",
      "openingHours": "2017년 12월 17일 (일) 6PM",
      "placeName": "대전 컨벤션센터(DCC) 1F 전시홀",
      "placeLot": "대전광역시 유성구 도룡동 4-19",
      "placeStreet": "대전광역시 유성구 엑스포로 107 대전컨벤션센터",
      "tel": "1588-2532",
      "homepage": "http://www.ggconcert.net",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 129
    },
    {
      "id": 29,
      "categoryId": 3,
      "displayInfoId": 31,
      "name": "콘서트",
      "description": "2017국카스텐 연말 전국투어[HAPPENING]\n",
      "content": "더 이상의 수식어가 필요없는 국카스텐의 연말 투어 HAPPENING\n",
      "event": "",
      "openingHours": "2017년 11월 25일(토) 오후 7시",
      "placeName": "KBS부산홀",
      "placeLot": "부산광역시 수영구 남천동 63",
      "placeStreet": "부산광역시 수영구 수영로 429 KBS부산방송총국",
      "tel": "1566-5490",
      "homepage": "http://www.wsmi.co.kr",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 129
    },
    {
      "id": 30,
      "categoryId": 3,
      "displayInfoId": 32,
      "name": "콘서트",
      "description": "2017버즈전국투어콘서트 'JUST ONE'",
      "content": "버즈와 함께하는 단 하나의 특별한 시간 JUST ONE\n2017년 연말을 더욱 따뜻한 이야기로 그려낼 JUST ONE\n가장 멋진 내일이 시작될 순간 JUST ONE\n2017 BUZZ CONCERT JUST ONE\n\n버즈 전국투어 콘서트 [JUST ONE]이 시작됩니다.\n미니앨범 BE ONE 발매와 함께 많은 사랑을 받은 버즈가\n전국 투어 콘서트로 여러분을 찾아갑니다.\n\n‘사랑하지 않은 것처럼’을 비롯한 미니앨범의 신곡들은 물론.\n남자를 몰라,겁쟁이, 나에게로 떠나는 여행등\n노래방 인기순위 랭킹의 곡들을 버즈와 함께 떼창 하는 시간!\n넘치는 흥을 주체할 수 없도록 신나게 달릴 메들리 곡들까지 만나볼 수 있는 다채로운 콘서트!\n\n2017년, 여러분의 연말을 가장 특별하게 마무리 할 단 하나의 공연 JUST ONE\nBand 버즈의 빛나는 모습으로 가득할 공연장으로 여러분을 초대합니다.",
      "event": "",
      "openingHours": "11월 18일(토) PM7 , 19일(일) PM5",
      "placeName": "경기도문화의전당 대극장",
      "placeLot": "경기도 수원시 팔달구 인계동 1117",
      "placeStreet": "경기도 수원시 팔달구 효원로307번길 20 경기도문화의전당",
      "tel": "02-1599-2005",
      "homepage": "http://www.sjticket.com",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 131
    },
    {
      "id": 30,
      "categoryId": 3,
      "displayInfoId": 33,
      "name": "콘서트",
      "description": "2017버즈전국투어콘서트 'JUST ONE'",
      "content": "버즈와 함께하는 단 하나의 특별한 시간 JUST ONE\n2017년 연말을 더욱 따뜻한 이야기로 그려낼 JUST ONE\n가장 멋진 내일이 시작될 순간 JUST ONE\n2017 BUZZ CONCERT JUST ONE\n\n버즈 전국투어 콘서트 [JUST ONE]이 시작됩니다.\n미니앨범 BE ONE 발매와 함께 많은 사랑을 받은 버즈가\n전국 투어 콘서트로 여러분을 찾아갑니다.\n\n‘사랑하지 않은 것처럼’을 비롯한 미니앨범의 신곡들은 물론.\n남자를 몰라,겁쟁이, 나에게로 떠나는 여행등\n노래방 인기순위 랭킹의 곡들을 버즈와 함께 떼창 하는 시간!\n넘치는 흥을 주체할 수 없도록 신나게 달릴 메들리 곡들까지 만나볼 수 있는 다채로운 콘서트!\n\n2017년, 여러분의 연말을 가장 특별하게 마무리 할 단 하나의 공연 JUST ONE\nBand 버즈의 빛나는 모습으로 가득할 공연장으로 여러분을 초대합니다.",
      "event": "",
      "openingHours": "12월 02일(토) PM7",
      "placeName": "KBS창원홀",
      "placeLot": "경상남도 창원시 의창구 신월동 97-4",
      "placeStreet": "경상남도 창원시 의창구 중앙대로 178 KBS창원방송총국",
      "tel": "02-1599-2006",
      "homepage": "http://www.sjticket.com",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 131
    },
    {
      "id": 30,
      "categoryId": 3,
      "displayInfoId": 34,
      "name": "콘서트",
      "description": "2017버즈전국투어콘서트 'JUST ONE'",
      "content": "버즈와 함께하는 단 하나의 특별한 시간 JUST ONE\n2017년 연말을 더욱 따뜻한 이야기로 그려낼 JUST ONE\n가장 멋진 내일이 시작될 순간 JUST ONE\n2017 BUZZ CONCERT JUST ONE\n\n버즈 전국투어 콘서트 [JUST ONE]이 시작됩니다.\n미니앨범 BE ONE 발매와 함께 많은 사랑을 받은 버즈가\n전국 투어 콘서트로 여러분을 찾아갑니다.\n\n‘사랑하지 않은 것처럼’을 비롯한 미니앨범의 신곡들은 물론.\n남자를 몰라,겁쟁이, 나에게로 떠나는 여행등\n노래방 인기순위 랭킹의 곡들을 버즈와 함께 떼창 하는 시간!\n넘치는 흥을 주체할 수 없도록 신나게 달릴 메들리 곡들까지 만나볼 수 있는 다채로운 콘서트!\n\n2017년, 여러분의 연말을 가장 특별하게 마무리 할 단 하나의 공연 JUST ONE\nBand 버즈의 빛나는 모습으로 가득할 공연장으로 여러분을 초대합니다.",
      "event": "",
      "openingHours": "12월 09일(토) PM7",
      "placeName": "KBS울산홀",
      "placeLot": "울산광역시 남구 달동 416-7",
      "placeStreet": "울산광역시 남구 번영로 212 한국방송공사",
      "tel": "02-1599-2007",
      "homepage": "http://www.sjticket.com",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 131
    },
    {
      "id": 30,
      "categoryId": 3,
      "displayInfoId": 35,
      "name": "콘서트",
      "description": "2017버즈전국투어콘서트 'JUST ONE'",
      "content": "버즈와 함께하는 단 하나의 특별한 시간 JUST ONE\n2017년 연말을 더욱 따뜻한 이야기로 그려낼 JUST ONE\n가장 멋진 내일이 시작될 순간 JUST ONE\n2017 BUZZ CONCERT JUST ONE\n\n버즈 전국투어 콘서트 [JUST ONE]이 시작됩니다.\n미니앨범 BE ONE 발매와 함께 많은 사랑을 받은 버즈가\n전국 투어 콘서트로 여러분을 찾아갑니다.\n\n‘사랑하지 않은 것처럼’을 비롯한 미니앨범의 신곡들은 물론.\n남자를 몰라,겁쟁이, 나에게로 떠나는 여행등\n노래방 인기순위 랭킹의 곡들을 버즈와 함께 떼창 하는 시간!\n넘치는 흥을 주체할 수 없도록 신나게 달릴 메들리 곡들까지 만나볼 수 있는 다채로운 콘서트!\n\n2017년, 여러분의 연말을 가장 특별하게 마무리 할 단 하나의 공연 JUST ONE\nBand 버즈의 빛나는 모습으로 가득할 공연장으로 여러분을 초대합니다.",
      "event": "",
      "openingHours": "12월 17일(일) PM5",
      "placeName": "KBS부산홀",
      "placeLot": "부산광역시 수영구 남천동 63",
      "placeStreet": "부산광역시 수영구 수영로 429 KBS부산방송총국",
      "tel": "02-1599-2008",
      "homepage": "http://www.sjticket.com",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 131
    },
    {
      "id": 30,
      "categoryId": 3,
      "displayInfoId": 36,
      "name": "콘서트",
      "description": "2017버즈전국투어콘서트 'JUST ONE'",
      "content": "버즈와 함께하는 단 하나의 특별한 시간 JUST ONE\n2017년 연말을 더욱 따뜻한 이야기로 그려낼 JUST ONE\n가장 멋진 내일이 시작될 순간 JUST ONE\n2017 BUZZ CONCERT JUST ONE\n\n버즈 전국투어 콘서트 [JUST ONE]이 시작됩니다.\n미니앨범 BE ONE 발매와 함께 많은 사랑을 받은 버즈가\n전국 투어 콘서트로 여러분을 찾아갑니다.\n\n‘사랑하지 않은 것처럼’을 비롯한 미니앨범의 신곡들은 물론.\n남자를 몰라,겁쟁이, 나에게로 떠나는 여행등\n노래방 인기순위 랭킹의 곡들을 버즈와 함께 떼창 하는 시간!\n넘치는 흥을 주체할 수 없도록 신나게 달릴 메들리 곡들까지 만나볼 수 있는 다채로운 콘서트!\n\n2017년, 여러분의 연말을 가장 특별하게 마무리 할 단 하나의 공연 JUST ONE\nBand 버즈의 빛나는 모습으로 가득할 공연장으로 여러분을 초대합니다.",
      "event": "",
      "openingHours": "12월 23일(토) PM7 , 24일(일) PM5",
      "placeName": "경북대학교 대강당",
      "placeLot": "대구광역시 북구 산격동 1370-1",
      "placeStreet": "대구광역시 북구 대학로 80 경북대학교",
      "tel": "02-1599-2009",
      "homepage": "http://www.sjticket.com",
      "email": "",
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 131
    }
  ]
}
```

> GET (카테고리별 상품 목록 페이지로 구하기): /api/displayinfos/category/3?pagesize=4&pageno=1

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
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
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
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
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
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
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
      "createDate": 1613642649000,
      "modifyDate": 1613642649000,
      "fileId": 119
    }
  ]
}
```

> GET (상품 세부사항 구하기): /api/displayinfos/1

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
    "createDate": 1613642649000,
    "modifyDate": 1613642649000,
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
      "deleteFlag": false,
      "createDate": 1613642650000,
      "modifyDate": 1613642650000
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
      "deleteFlag": false,
      "createDate": 1613642648000,
      "modifyDate": 1613642648000
    }
  ],
  "avgScore": 3,
  "productPrices": [
    {
      "id": 3,
      "productId": 1,
      "priceTypeName": "B",
      "price": 2000,
      "discountRate": 50.0,
      "createDate": 1613642652000,
      "modifyDate": 1613642652000
    },
    {
      "id": 2,
      "productId": 1,
      "priceTypeName": "Y",
      "price": 3000,
      "discountRate": 33.0,
      "createDate": 1613642652000,
      "modifyDate": 1613642652000
    },
    {
      "id": 1,
      "productId": 1,
      "priceTypeName": "A",
      "price": 6000,
      "discountRate": 20.0,
      "createDate": 1613642652000,
      "modifyDate": 1613642652000
    }
  ]
}
```

> GET (상품 댓글 목록 구하기): /api/comments

```json
{
  "totalCount": 15,
  "commentCount": 15,
  "reservationUserComments": [
    {
      "id": 15,
      "productId": 1,
      "reservationInfoId": 15,
      "score": 5.0,
      "reservationEmail": "dorosi@connect.co.kr",
      "comment": "즐거움!!!",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 14,
      "productId": 1,
      "reservationInfoId": 14,
      "score": 5.0,
      "reservationEmail": "kimkorea@connect.co.kr",
      "comment": "또 가고 싶어.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 13,
      "productId": 1,
      "reservationInfoId": 13,
      "score": 4.0,
      "reservationEmail": "kimmy@connect.co.kr",
      "comment": "재미남.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 12,
      "productId": 1,
      "reservationInfoId": 12,
      "score": 4.0,
      "reservationEmail": "kinsujung@connect.co.kr",
      "comment": "좋았음.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 11,
      "productId": 1,
      "reservationInfoId": 11,
      "score": 3.0,
      "reservationEmail": "kangchan@connect.co.kr",
      "comment": "괜찮았어요.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 10,
      "productId": 1,
      "reservationInfoId": 10,
      "score": 1.0,
      "reservationEmail": "leesunsin@connect.co.kr",
      "comment": "최고로 실망...",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 9,
      "productId": 1,
      "reservationInfoId": 9,
      "score": 2.0,
      "reservationEmail": "hong@connect.co.kr",
      "comment": "실망....",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 8,
      "productId": 1,
      "reservationInfoId": 8,
      "score": 3.0,
      "reservationEmail": "kimrain@connect.co.kr",
      "comment": "보통이였어요.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 7,
      "productId": 1,
      "reservationInfoId": 7,
      "score": 5.0,
      "reservationEmail": "kimsangkun@connect.co.kr",
      "comment": "최고!!!!!!!!",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 6,
      "productId": 1,
      "reservationInfoId": 6,
      "score": 4.0,
      "reservationEmail": "kimjinho@connect.co.kr",
      "comment": "오 재미남!!",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 5,
      "productId": 1,
      "reservationInfoId": 5,
      "score": 3.0,
      "reservationEmail": "goarum@connect.co.kr",
      "comment": "지루했어요..",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 4,
      "productId": 1,
      "reservationInfoId": 4,
      "score": 2.0,
      "reservationEmail": "dominsang@connect.co.kr",
      "comment": "가격대비 약간은 실망이었어요.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 3,
      "productId": 1,
      "reservationInfoId": 3,
      "score": 5.0,
      "reservationEmail": "hongsangsu@connect.co.kr",
      "comment": "또 가보고 싶어요.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 2,
      "productId": 1,
      "reservationInfoId": 2,
      "score": 5.0,
      "reservationEmail": "kimjinsu@connect.co.kr",
      "comment": "최고!!!!",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 1,
      "productId": 1,
      "reservationInfoId": 1,
      "score": 4.0,
      "reservationEmail": "carami@connect.co.kr",
      "comment": "좋았어요.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    }
  ]
}
```

> GET (상품별 댓글 목록 구하기): /api/comments/product/1

```json
{
  "totalCount": 15,
  "commentCount": 15,
  "reservationUserComments": [
    {
      "id": 15,
      "productId": 1,
      "reservationInfoId": 15,
      "score": 5.0,
      "reservationEmail": "dorosi@connect.co.kr",
      "comment": "즐거움!!!",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 14,
      "productId": 1,
      "reservationInfoId": 14,
      "score": 5.0,
      "reservationEmail": "kimkorea@connect.co.kr",
      "comment": "또 가고 싶어.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 13,
      "productId": 1,
      "reservationInfoId": 13,
      "score": 4.0,
      "reservationEmail": "kimmy@connect.co.kr",
      "comment": "재미남.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 12,
      "productId": 1,
      "reservationInfoId": 12,
      "score": 4.0,
      "reservationEmail": "kinsujung@connect.co.kr",
      "comment": "좋았음.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 11,
      "productId": 1,
      "reservationInfoId": 11,
      "score": 3.0,
      "reservationEmail": "kangchan@connect.co.kr",
      "comment": "괜찮았어요.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 10,
      "productId": 1,
      "reservationInfoId": 10,
      "score": 1.0,
      "reservationEmail": "leesunsin@connect.co.kr",
      "comment": "최고로 실망...",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 9,
      "productId": 1,
      "reservationInfoId": 9,
      "score": 2.0,
      "reservationEmail": "hong@connect.co.kr",
      "comment": "실망....",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 8,
      "productId": 1,
      "reservationInfoId": 8,
      "score": 3.0,
      "reservationEmail": "kimrain@connect.co.kr",
      "comment": "보통이였어요.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 7,
      "productId": 1,
      "reservationInfoId": 7,
      "score": 5.0,
      "reservationEmail": "kimsangkun@connect.co.kr",
      "comment": "최고!!!!!!!!",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 6,
      "productId": 1,
      "reservationInfoId": 6,
      "score": 4.0,
      "reservationEmail": "kimjinho@connect.co.kr",
      "comment": "오 재미남!!",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 5,
      "productId": 1,
      "reservationInfoId": 5,
      "score": 3.0,
      "reservationEmail": "goarum@connect.co.kr",
      "comment": "지루했어요..",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 4,
      "productId": 1,
      "reservationInfoId": 4,
      "score": 2.0,
      "reservationEmail": "dominsang@connect.co.kr",
      "comment": "가격대비 약간은 실망이었어요.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 3,
      "productId": 1,
      "reservationInfoId": 3,
      "score": 5.0,
      "reservationEmail": "hongsangsu@connect.co.kr",
      "comment": "또 가보고 싶어요.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 2,
      "productId": 1,
      "reservationInfoId": 2,
      "score": 5.0,
      "reservationEmail": "kimjinsu@connect.co.kr",
      "comment": "최고!!!!",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 1,
      "productId": 1,
      "reservationInfoId": 1,
      "score": 4.0,
      "reservationEmail": "carami@connect.co.kr",
      "comment": "좋았어요.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    }
  ]
}
```

> GET (상품별 댓글 목록 페이지로 구하기): /api/comments/product/1?pagesize=5&pageno=1

```json
{
  "totalCount": 15,
  "commentCount": 5,
  "reservationUserComments": [
    {
      "id": 15,
      "productId": 1,
      "reservationInfoId": 15,
      "score": 5.0,
      "reservationEmail": "dorosi@connect.co.kr",
      "comment": "즐거움!!!",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 14,
      "productId": 1,
      "reservationInfoId": 14,
      "score": 5.0,
      "reservationEmail": "kimkorea@connect.co.kr",
      "comment": "또 가고 싶어.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 13,
      "productId": 1,
      "reservationInfoId": 13,
      "score": 4.0,
      "reservationEmail": "kimmy@connect.co.kr",
      "comment": "재미남.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 12,
      "productId": 1,
      "reservationInfoId": 12,
      "score": 4.0,
      "reservationEmail": "kinsujung@connect.co.kr",
      "comment": "좋았음.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    },
    {
      "id": 11,
      "productId": 1,
      "reservationInfoId": 11,
      "score": 3.0,
      "reservationEmail": "kangchan@connect.co.kr",
      "comment": "괜찮았어요.",
      "createDate": 1613642653000,
      "modifyDate": 1613642653000
    }
  ]
}
```