package kr.ac.hs.se.model;

public enum WinningRank {
    ONE("1등") {
        @Override
        public WinningRank getNextRank() {
            return ONE;
        }
    },
    TWO("2등") {
        @Override
        public WinningRank getNextRank() {
            return ONE;
        }
    },
    THREE("3등") {
        @Override
        public WinningRank getNextRank() {
            return TWO;
        }
    },
    FOUR("4등") {
        @Override
        public WinningRank getNextRank() {
            return THREE;
        }
    },
    FIVE("5등") {
        @Override
        public WinningRank getNextRank() {
            return FOUR;
        }
    },
    OTHERS("낙첨") {
        @Override
        public WinningRank getNextRank() {
            return FIVE;
        }
    };

    private final String rank;

    WinningRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public abstract WinningRank getNextRank();
}
