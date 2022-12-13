package pairmatching.service;

import pairmatching.domain.*;
import pairmatching.dto.MissionDto;
import pairmatching.dto.PairMatchingDto;
import pairmatching.utils.PairMatchingRandom;

public class PairMatchingService {
    private PairMatching pairMatching;
    private MissionPairHistory missionPairHistory;

    public PairMatchingService() {
        this.pairMatching = initPairMatching();
        this.missionPairHistory = new MissionPairHistory();
    }

    private PairMatching initPairMatching() {
        return new PairMatching(
                new Crews(),
                new Matching(new PairMatchingRandom())
        );
    }

    public Mission generateMission(MissionDto missionDto) {
        System.out.println("!!");
        Course.validate(missionDto.getCourse());
        Level.validate(missionDto.getLevel());
        return Mission.of(missionDto.getMission());
    }

    public boolean isMatched(Mission mission) {
        return missionPairHistory.isExistPair(mission);
    }

    public boolean isRematching(ReMatching reMatching) {
        return reMatching.isReMatching();
    }

    public PairMatchingDto match(Mission mission) {
        Pair pair = pairMatching.match();
        missionPairHistory.putMissionPair(mission, pair);
        return new PairMatchingDto(pair);
    }

    public PairMatchingDto getPairMatchingResult(Mission mission) {
        Pair pair = missionPairHistory.getPairsByMission(mission);
        return new PairMatchingDto(pair);
    }

    public void reset() {
        missionPairHistory.resetMissionPair();
        pairMatching.reset();
    }
}
