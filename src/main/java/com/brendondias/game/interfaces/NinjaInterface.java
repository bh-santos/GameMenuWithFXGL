package com.brendondias.game.interfaces;

public interface NinjaInterface {
        public void basicAttack(com.brendondias.game.logic.Ninja target);
        public void useSkillOne(com.brendondias.game.logic.Ninja target);
        public void useSkillTwo(com.brendondias.game.logic.Ninja target);
        public void useSkillThree(com.brendondias.game.logic.Ninja target);
        public void useSkillFour(com.brendondias.game.logic.Ninja target);
        public void receiveSkill(double damageTaken);
        public void infoNinja();
        public void useSkill(int abilitySelect, com.brendondias.game.logic.Ninja targetNinja);
}
