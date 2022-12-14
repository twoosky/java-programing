package pairmatching.service;

import pairmatching.domain.*;
import pairmatching.dto.MissionDto;
import pairmatching.dto.MissionInfoDto;
import pairmatching.dto.PairMatchingDto;
import pairmatching.utils.PairMatchingRandom;

public class PairMatchingService {
    private final PairMatching pairMatching;
    private final MissionPairHistories missionPairHistories;

    public PairMatchingService() {
        this.pairMatching = new PairMatching(new PairMatchingRandom());
        this.missionPairHistories = new MissionPairHistories();
    }

    public MissionDto generateMission(MissionInfoDto missionDto) {
        Level.validate(missionDto.getLevel());
        return new MissionDto(Course.of(missionDto.getCourse()), Mission.of(missionDto.getMission()));
    }

    public boolean isMatched(MissionDto dto) {
        return missionPairHistories.isExistPair(dto.getCourse(), dto.getMission());
    }

    public boolean isRematching(ReMatching reMatching, MissionDto dto) {
        boolean isRematch = reMatching.isReMatching();
        if (isRematch) {
            missionPairHistories.resetByMission(dto.getCourse(), dto.getMission());
        }
        return isRematch;
    }

    public PairMatchingDto match(MissionDto dto) {
        Pair pair = pairMatching.match(dto.getCourse());
        missionPairHistories.putMissionPair(dto.getCourse(), dto.getMission(), pair);
        return new PairMatchingDto(pair);
    }

    public PairMatchingDto getPairMatchingResult(MissionDto dto) {
        Pair pair = missionPairHistories.getPair(dto.getCourse(), dto.getMission());
        return new PairMatchingDto(pair);
    }

    public void reset() {
        missionPairHistories.reset();
        pairMatching.reset();
    }
}
