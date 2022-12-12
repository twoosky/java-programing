package pairmatching.domain;

public enum Mission {
    CAR("자동차경주", false),
    LOTTO("로또", false),
    BASEBALL("숫자야구게임", false),
    BUCKET("장바구니", false),
    PAY("결제", false),
    SUBWAY("지하철노선도", false),
    PERFORMANCE("성능개선", false),
    DEPLOY("배포", false);

    private final String name;
    private final boolean history;

    Mission(String name, boolean history) {
        this.name = name;
        this.history = history;
    }
}
