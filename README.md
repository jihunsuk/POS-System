# POS-System
> 편의점의 포스시스템이다. 자세한 기능은 유스케이스 명세서의 그림에서 볼 수 있다. <br>
> Java와 MySQL을 사용해 구현했다.


### 유스케이스 명세서
![UC 명세서](https://blogfiles.pstatic.net/MjAxODA1MTdfMjM0/MDAxNTI2NTY0NzMwNzIw.vIbeu0jtCc_MUyRKNXVNWU7DpHEGbNvs7iZVkUycMocg.fZTJkdZHqHMRWWYM_zvE8B7j3NeEZHVSWhVlYWFT-EYg.PNG.wlgnscjstk3/UseCase_.png)

```
이 포스시스템의 주 행위자는 직원이다. 포스시스템을 사용하려면 회원으로 등록이 되어있어야 한다. 
회원으로 등록되지 않았을 경우 회원가입화면을 통해 회원 등록이 가능하다. 이후 포스시스템에 로그인하여 홈 화면으로 들어간다.
로그인을 한 직원은 상품과 카테고리를 관리할 수 있고, 고객이 구매하고자 하는 상품을 장바구니에 추가하여 현금과 카드로 
결제를 할 수 있다. 또한 지금까지의 매출정보를 포스시스템이 자동으로 추가해주어, 이를 매출현황확인에서 확인할 수 있다.
실제로 포스시스템을 사용하기 위해서는 로그인이 필수적이므로 회원가입을 제외한 모든 use case들은 로그인과 포함관계에 있다.
그리고 직원은 크게 회원가입, 매출현황확인, 카테고리관리, 상품관리, 장바구니관리, 주문결제의 기능을 사용할 수 있으므로,
직원과 각 use case는 일반화 관계에 있다. 매출현황확인에는 일, 월, 년 매출 확인 기능이 있으며 반드시 선택해야함으로
일반화 관계에 있다. 상품관리에는 상품검색, 삭제, 수정, 등록, 상세조회, 카테고리등록, 수정, 삭제가 있는데 상품관리에서
이미 상품의 목록을 간단하게 보여주고 상세조회에서 상세하게 보여주기 때문에 상세조회는 확장관계가 된다. 다른 기능은 반드시
선택해야함으로 일반화 관계에 있다. 장바구니관리에는 장바구니상품등록, 삭제가 있는데 반드시 선택해야함으로 일반화 관계에 있다.
주문결제에는 현금결제, 카드결제가 있으며 반드시 선택해야함으로 일반화 관계에 있다.
```

### 클래스 다이어그램
![Class Diagram](http://postfiles7.naver.net/MjAxODA1MTdfMjU3/MDAxNTI2NTY1MDU2NTc2.FRU5OrxDV8UCmGCm7cuV74oKmEXaoTBcmj9nv3GDtvsg.Qw4QhwC40KeKTaVsWyGG1iJ_GD6fZyIaNnSPp5gweWMg.JPEG.wlgnscjstk3/%ED%81%B4%EB%9E%98%EC%8A%A4_%EB%8B%A4%EC%9D%B4%EC%96%B4%EA%B7%B8%EB%9E%A8.jpg?type=w2)

