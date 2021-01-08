package kr.ac.hs.se.model;

public enum WinningResult {
    ONE(1, "1등") {
        @Override
        public WinningResult getNextRank() {
            return ONE;
        }
    },
    TWO(2, "2등") {
        @Override
        public WinningResult getNextRank() {
            return ONE;
        }
    },
    THREE(3, "3등") {
        @Override
        public WinningResult getNextRank() {
            return TWO;
        }
    },
    FOUR(4, "4등") {
        @Override
        public WinningResult getNextRank() {
            return THREE;
        }
    },
    FIVE(5, "5등") {
        @Override
        public WinningResult getNextRank() {
            return FOUR;
        }
    },
    SIX(6, "낙첨") {
        @Override
        public WinningResult getNextRank() {
            return FIVE;
        }
    },
    SEVEN(7, "낙첨") {
        @Override
        public WinningResult getNextRank() {
            return SIX;
        }
    },
    EIGHT(8, "낙첨") {
        @Override
        public WinningResult getNextRank() {
            return SEVEN;
        }
    };

    private final int rank;
    private final String result;

    WinningResult(int rank, String result) {
        this.rank = rank;
        this.result = result;
    }

    public int getRank() {
        return rank;
    }

    public String getResult() {
        return result;
    }

    public abstract WinningResult getNextRank();
}
