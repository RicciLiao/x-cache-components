package ricciliao.x.cache.pojo.common;

import ricciliao.x.cache.pojo.CacheDto;
import ricciliao.x.component.challenge.Challenge;

import java.io.Serial;
import java.util.Objects;

public class ChallengeCacheDto extends CacheDto {
    @Serial
    private static final long serialVersionUID = 4104712894030416422L;

    private Challenge challenge;

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    @Override
    public CacheDto generateCacheKey() {

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChallengeCacheDto that)) return false;
        return Objects.equals(getChallenge(), that.getChallenge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChallenge());
    }
}
