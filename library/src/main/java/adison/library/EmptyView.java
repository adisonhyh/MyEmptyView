/**
 * ø* Project Name:culiulib File Name:EmptyView.java Package Name:com.culiu.core.widget Date:2014-12-10上午2:33:35 Copyright (c) 2014,
 * adison All Rights Reserved.
 */

package adison.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/**
 * @description 空布局或者错误布局统一处理自定义控件. <br/>
 *
 * @author adison
 * @date 2014-12-10 上午2:33:35
 */
public class EmptyView extends RelativeLayout {

	/**
	 * 加载中自定义View
	 */
	private View mLoadingView;

	// /**
	// * 加载中自定义Dialog
	// */
	// private Dialog mLoadingDialog;

	/**
	 * 空数据
	 */
	private View mEmptyView;

	/**
	 * 错误
	 */
	private View mErrorView;

	/**
	 * 不正常
	 */
	private View mAbnormalView;

	private LayoutInflater mLayoutInflater;

       /**
         * 数据正常的内容
       */
	private View content;

	private boolean mInitViews = true;

	private boolean mInvalidateView;


	public EmptyView(Context context) {
		super(context);
		init(null);
	}

	public EmptyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}

	public EmptyView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}

	private void init(AttributeSet attrs) {
		mLayoutInflater = LayoutInflater.from(getContext());
		if (attrs != null) {
			// 加载属性
			TypedArray typedArray = getContext().getTheme()
					.obtainStyledAttributes(attrs, R.styleable.EmptyView, 0, 0);

			try {
				int loadingViewResId = typedArray.getResourceId(
						R.styleable.EmptyView_loadingView, 0);
				if (loadingViewResId > 0) {
					mLoadingView = mLayoutInflater.inflate(loadingViewResId,
							null);
				}

				int emptyViewResId = typedArray.getResourceId(
						R.styleable.EmptyView_emptyView, 0);
				if (emptyViewResId > 0) {
					mEmptyView = mLayoutInflater.inflate(emptyViewResId, null);
				}

				int errorViewResId = typedArray.getResourceId(
						R.styleable.EmptyView_errorView, 0);
				if (errorViewResId > 0) {
					mErrorView = mLayoutInflater.inflate(errorViewResId, null);
				}
				int abnormalViewResId = typedArray.getResourceId(
						R.styleable.EmptyView_abnormalView, 0);
				if (abnormalViewResId > 0) {
					mAbnormalView = mLayoutInflater.inflate(abnormalViewResId,
							null);
				}
			} finally {
				typedArray.recycle();
			}
		}
	}

	// ================================================================================
	// Getters
	// ================================================================================
	public View getContent() {
		return content;
	}

	public View getLoadingView() {
		return mLoadingView;
	}

	public View getEmptyView() {
		return mEmptyView;
	}

	public View getErrorView() {
		return mErrorView;
	}

	public View getAbnormalView() {
		return mAbnormalView;
	}

	// public Dialog getLoadingDialog() {
	// return mLoadingDialog;
	// }

	// ================================================================================
	// Setters
	// ================================================================================

	public void setLoadingView(View view) {
		setLoadingView(view, false);
	}

	public void setLoadingView(View view, boolean invalidateView) {
		if (view == null) {
			throw new IllegalArgumentException("View must not be null.");
		}
		mLoadingView = view;
		mInvalidateView = invalidateView;
	}

	public void setLoadingView(int resId) {
		setLoadingView(resId, false);
	}

	public void setLoadingView(int resId, boolean invalidateView) {
		if (resId <= 0) {
			throw new IllegalArgumentException(
					"View resource id must be greater than 0.");
		}
		mLoadingView = mLayoutInflater.inflate(resId, null);
		mInvalidateView = invalidateView;
	}

	public void setLoadingView(View view, OnClickListener clickListener) {
		setLoadingView(view, clickListener, false);
	}

	public void setLoadingView(View view, OnClickListener clickListener,
			boolean invalidateView) {
		if (view == null) {
			throw new IllegalArgumentException("View must not be null.");
		}
		mLoadingView = view;
		mLoadingView.setOnClickListener(clickListener);
		mInvalidateView = invalidateView;
	}

	public void setLoadingView(int resId, OnClickListener clickListener) {
		setLoadingView(resId, clickListener, false);
	}

	public void setLoadingView(int resId, OnClickListener clickListener,
			boolean invalidateView) {
		if (resId <= 0) {
			throw new IllegalArgumentException(
					"View resource id must be greater than 0.");
		}
		mLoadingView = mLayoutInflater.inflate(resId, null);
		mLoadingView.setOnClickListener(clickListener);
		mInvalidateView = invalidateView;
	}

	public void setLoadingViewClickListener(OnClickListener clickListener) {
		if (mLoadingView == null) {
			throw new IllegalStateException(
					"Loading view is null. Cannot set click listener.");
		}
		mLoadingView.setOnClickListener(clickListener);
	}

	public void setEmptyView(View view) {
		setEmptyView(view, false);
	}

	public void setEmptyView(View view, boolean invalidateView) {
		if (view == null) {
			throw new IllegalArgumentException("View must not be null.");
		}
		mEmptyView = view;
		mInvalidateView = invalidateView;
	}

	public void setEmptyView(int resId) {
		setEmptyView(resId, false);
	}

	public void setEmptyView(int resId, boolean invalidateView) {
		if (resId <= 0) {
			throw new IllegalArgumentException(
					"View resource id must be greater than 0.");
		}
		mEmptyView = mLayoutInflater.inflate(resId, null);
		mInvalidateView = invalidateView;
	}

	public void setEmptyView(View view, OnClickListener clickListener) {
		setEmptyView(view, clickListener, false);
	}

	public void setEmptyView(View view, OnClickListener clickListener,
			boolean invalidateView) {
		if (view == null) {
			throw new IllegalArgumentException("View must not be null.");
		}
		mEmptyView = view;
		mEmptyView.setOnClickListener(clickListener);
		mInvalidateView = invalidateView;
	}

	public void setEmptyView(int resId, OnClickListener clickListener) {
		setEmptyView(resId, clickListener, false);
	}

	public void setEmptyView(int resId, OnClickListener clickListener,
			boolean invalidateView) {
		if (resId <= 0) {
			throw new IllegalArgumentException(
					"View resource id must be greater than 0.");
		}
		mEmptyView = mLayoutInflater.inflate(resId, null);
		mEmptyView.setOnClickListener(clickListener);
		mInvalidateView = invalidateView;
	}

	public void setEmptyViewClickListener(OnClickListener clickListener) {
		if (mEmptyView == null) {
			throw new IllegalStateException(
					"Empty view is null. Cannot set click listener.");
		}
		mEmptyView.setOnClickListener(clickListener);
	}

	public void setErrorView(View view) {
		setErrorView(view, false);
	}

	public void setErrorView(View view, boolean invalidateView) {
		if (view == null) {
			throw new IllegalArgumentException("View must not be null.");
		}
		mErrorView = view;
		mInvalidateView = invalidateView;
	}

	public void setErrorView(int resId) {
		setErrorView(resId, false);
	}

	public void setErrorView(int resId, boolean invalidateView) {
		if (resId <= 0) {
			throw new IllegalArgumentException(
					"View resource id must be greater than 0.");
		}
		mErrorView = mLayoutInflater.inflate(resId, null);
		mInvalidateView = invalidateView;
	}

	public void setErrorView(View view, OnClickListener clickListener) {
		setErrorView(view, clickListener, false);
	}

	public void setErrorView(View view, OnClickListener clickListener,
			boolean invalidateView) {
		if (view == null) {
			throw new IllegalArgumentException("View must not be null.");
		}
		mErrorView = view;
		mErrorView.setOnClickListener(clickListener);
		mInvalidateView = invalidateView;
	}

	public void setErrorView(int resId, OnClickListener clickListener) {
		setErrorView(resId, clickListener, false);
	}

	public void setErrorView(int resId, OnClickListener clickListener,
			boolean invalidateView) {
		if (resId <= 0) {
			throw new IllegalArgumentException(
					"View resource id must be greater than 0.");
		}
		mErrorView = mLayoutInflater.inflate(resId, null);
		mErrorView.setOnClickListener(clickListener);
		mInvalidateView = invalidateView;
	}

	public void setErrorViewClickListener(OnClickListener clickListener) {
		if (mErrorView == null) {
			throw new IllegalStateException(
					"Error view is null. Cannot set click listener.");
		}
		mErrorView.setOnClickListener(clickListener);
	}

	public void setAbnormalView(View view) {
		setAbnormalView(view, false);
	}

	public void setAbnormalView(View view, boolean invalidateView) {
		if (view == null) {
			throw new IllegalArgumentException("View must not be null.");
		}
		mAbnormalView = view;
		mInvalidateView = invalidateView;
	}

	public void setAbnormalView(int resId) {
		setAbnormalView(resId, false);
	}

	public void setAbnormalView(int resId, boolean invalidateView) {
		if (resId <= 0) {
			throw new IllegalArgumentException(
					"View resource id must be greater than 0.");
		}
		mAbnormalView = mLayoutInflater.inflate(resId, null);
		mInvalidateView = invalidateView;
	}

	public void setAbnormalView(View view, OnClickListener clickListener) {
		setAbnormalView(view, clickListener, false);
	}

	public void setAbnormalView(View view, OnClickListener clickListener,
			boolean invalidateView) {
		if (view == null) {
			throw new IllegalArgumentException("View must not be null.");
		}
		mAbnormalView = view;
		mAbnormalView.setOnClickListener(clickListener);
		mInvalidateView = invalidateView;
	}

	public void setAbnormalView(int resId, OnClickListener clickListener) {
		setErrorView(resId, clickListener, false);
	}

	public void setAbnormalView(int resId, OnClickListener clickListener,
			boolean invalidateView) {
		if (resId <= 0) {
			throw new IllegalArgumentException(
					"View resource id must be greater than 0.");
		}
		mAbnormalView = mLayoutInflater.inflate(resId, null);
		mAbnormalView.setOnClickListener(clickListener);
		mInvalidateView = invalidateView;
	}

	public void setAbnormalViewClickListener(OnClickListener clickListener) {
		if (mAbnormalView == null) {
			throw new IllegalStateException(
					"Error view is null. Cannot set click listener.");
		}
		mAbnormalView.setOnClickListener(clickListener);
	}


	// ================================================================================
	// 处理各种状态事件
	// ================================================================================

	public static enum State {
		LOADING, EMPTY, ERROR, DISMISS, ABNORMAL
	}

	public void showLoadingView() {
		showView(State.LOADING);
	}

	public void showEmptyView() {
		showView(State.EMPTY);
	}

	public void showErrorView() {
		showView(State.ERROR);
	}

	public void dismissLoadingView() {
		showView(State.DISMISS);
	}

	public void showAbnormalView() {
		showView(State.ABNORMAL);
	}

	public void showContent() {
		if (mLoadingView != null) {
			mLoadingView.setVisibility(View.GONE);
		}

		if (mEmptyView != null) {
			mEmptyView.setVisibility(View.GONE);
		}

		if (mErrorView != null) {
			mErrorView.setVisibility(View.GONE);
		}
		if (mAbnormalView != null) {
			mAbnormalView.setVisibility(View.GONE);
		}
	}

	public void showView(State state) {
		if (mInitViews || mInvalidateView) {
			initViews();
			mInitViews = mInvalidateView = false;
		}
		boolean showLoadingView = false;
		boolean showEmptyView = false;
		boolean showErrorView = false;
		boolean showAbnormalView = false;

		switch (state) {
		case LOADING:
			showLoadingView = true;
			break;
		case EMPTY:
			showEmptyView = true;
			break;
		case ERROR:
			showErrorView = true;
			break;
		case DISMISS:
			showLoadingView = false;
		case ABNORMAL:
			showAbnormalView = true;
		}

		if (mLoadingView != null) {
			mLoadingView.setVisibility(showLoadingView ? View.VISIBLE
					: View.GONE);
		}

		if (mEmptyView != null) {
			mEmptyView.setVisibility(showEmptyView ? View.VISIBLE : View.GONE);
		}

		if (mErrorView != null) {
			mErrorView.setVisibility(showErrorView ? View.VISIBLE : View.GONE);
		}
		if (mAbnormalView != null) {
			mAbnormalView.setVisibility(showAbnormalView ? View.VISIBLE
					: View.GONE);
		}
	}

	/**
	 * initViews:初始化控件. <br/>
	 * 
	 * @author adison
	 */
	private void initViews() {
		int wC = LayoutParams.MATCH_PARENT;
		LayoutParams layoutParams = new LayoutParams(wC, wC);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);

		if (mEmptyView != null) {
			ViewGroup parent = (ViewGroup) mEmptyView.getParent();
			if (parent != null) {
				parent.removeView(mEmptyView);
			}
			mEmptyView.setLayoutParams(layoutParams);
			addView(mEmptyView);
		}

		if (mErrorView != null) {
			ViewGroup parent = (ViewGroup) mErrorView.getParent();
			if (parent != null) {
				parent.removeView(mErrorView);
			}
			mErrorView.setLayoutParams(layoutParams);
			addView(mErrorView);
		}
		if (mAbnormalView != null) {
			ViewGroup parent = (ViewGroup) mAbnormalView.getParent();
			if (parent != null) {
				parent.removeView(mAbnormalView);
			}
			mAbnormalView.setLayoutParams(layoutParams);
			addView(mAbnormalView);
		}

		if (mLoadingView != null) {
			ViewGroup parent = (ViewGroup) mLoadingView.getParent();
			if (parent != null) {
				parent.removeView(mLoadingView);
			}
			mLoadingView.setLayoutParams(layoutParams);
			addView(mLoadingView);
		}

	}

	@Override
	public final void addView(View child, ViewGroup.LayoutParams params) {
		if (getChildCount() > 0) {
			throw new IllegalStateException(
					"EmptyView can host only one direct child");
		}

		// 添加 child
		content = child;
		super.addView(child, -1, params);

		// 初始化控件
		initViews();
	}




}
