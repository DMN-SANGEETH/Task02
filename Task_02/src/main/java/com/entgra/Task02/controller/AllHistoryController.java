pin-lg .ant-spin-text {
  padding-top: 11px;
}
.ant-spin-nested-loading > div > .ant-spin-lg.ant-spin-show-text .ant-spin-dot {
  margin-top: -26px;
}
.ant-spin-container {
  position: relative;
  transition: opacity 0.3s;
}
.ant-spin-container::after {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  z-index: 10;
  display: none \9;
  width: 100%;
  height: 100%;
  background: #fff;
  opacity: 0;
  transition: all 0.3s;
  content: '';
  pointer-events: none;
}
.ant-spin-blur {
  clear: both;
  overflow: hidden;
  opacity: 0.5;
  user-select: none;
  pointer-events: none;
}
.ant-spin-blur::after {
  opacity: 0.4;
  pointer-events: auto;
}
.ant-spin-tip {
  color: rgba(0, 0, 0, 0.45);
}
.ant-spin-dot {
  position: rel