package com.monjeu.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.monjeu.view.TextureFactory;

public class Explosion extends GameElement{

	private Animation<TextureRegion> animation;
    private float stateTime = 0f;
    private boolean finished = false;

    // Number of columns and rows in your explosion sprite sheet
    private static final int FRAME_COLS = 5;
    private static final int FRAME_ROWS = 4;

    // The width and height of each frame in the sprite sheet (in pixels).
    private static final int FRAME_WIDTH = 184;
    private static final int FRAME_HEIGHT = 184;

    // How large you want the explosion to be rendered on-screen.
    private static final int EXPLOSION_RENDER_SIZE = 64;

    // Duration of each frame in seconds (e.g., 0.05 = 50 ms)
    private static final float FRAME_DURATION = 0.05f;
    
    // NEW: Reference to the enemy that was hit
    private Wall enemyToReset = null;

    // Constructor without enemy reference
    public Explosion(int x, int y) {
        super(x, y, EXPLOSION_RENDER_SIZE, EXPLOSION_RENDER_SIZE);
        initAnimation();
    }
    
    // NEW: Constructor that accepts an enemy reference.
    public Explosion(int x, int y, Wall enemy) {
        super(x, y, EXPLOSION_RENDER_SIZE, EXPLOSION_RENDER_SIZE);
        this.enemyToReset = enemy;
        initAnimation();
    }
    
    // Initialize the explosion animation from the sprite sheet
    private void initAnimation() {
        Texture explosionSheet = TextureFactory.getInstance().getExplosionSheet();
        TextureRegion[][] tmp = TextureRegion.split(explosionSheet, FRAME_WIDTH, FRAME_HEIGHT);
        TextureRegion[] frames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int row = 0; row < FRAME_ROWS; row++) {
            for (int col = 0; col < FRAME_COLS; col++) {
                frames[index++] = tmp[row][col];
            }
        }
        animation = new Animation<>(FRAME_DURATION, frames);
    }

    @Override
    public void update(float delta) {
        stateTime += delta;
        if (animation.isAnimationFinished(stateTime)) {
            finished = true;
        }
    }

   
    public void render(SpriteBatch batch) {
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, false);
        batch.draw(currentFrame, x, y, width, height);
    }

    @Override
    public Rectangle getHitBox() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * @return true if the explosion animation has finished playing.
     */
    public boolean isFinished() {
        return finished;
    }
    
    /**
     * @return the enemy that should be reset after the explosion ends.
     */
    public Wall getEnemyToReset() {
        return enemyToReset;
    }
    
    /**
     * Clears the stored enemy reference.
     */
    public void clearEnemyToReset() {
        enemyToReset = null;
    }

	
}
