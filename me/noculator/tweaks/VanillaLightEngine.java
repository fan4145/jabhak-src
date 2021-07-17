/*      */ package me.noculator.tweaks;
/*      */ 
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.BufferedOutputStream;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.Closeable;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.Flushable;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStream;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.io.PrintStream;
/*      */ import java.io.Reader;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.io.Writer;
/*      */ import java.net.HttpURLConnection;
/*      */ import java.net.InetSocketAddress;
/*      */ import java.net.MalformedURLException;
/*      */ import java.net.Proxy;
/*      */ import java.net.URI;
/*      */ import java.net.URISyntaxException;
/*      */ import java.net.URL;
/*      */ import java.net.URLEncoder;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.CharBuffer;
/*      */ import java.nio.charset.Charset;
/*      */ import java.nio.charset.CharsetEncoder;
/*      */ import java.security.AccessController;
/*      */ import java.security.GeneralSecurityException;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.security.SecureRandom;
/*      */ import java.security.cert.X509Certificate;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.Callable;
/*      */ import java.util.concurrent.atomic.AtomicInteger;
/*      */ import java.util.concurrent.atomic.AtomicReference;
/*      */ import java.util.zip.GZIPInputStream;
/*      */ import javax.net.ssl.HostnameVerifier;
/*      */ import javax.net.ssl.HttpsURLConnection;
/*      */ import javax.net.ssl.SSLContext;
/*      */ import javax.net.ssl.SSLSession;
/*      */ import javax.net.ssl.SSLSocketFactory;
/*      */ import javax.net.ssl.TrustManager;
/*      */ import javax.net.ssl.X509TrustManager;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class VanillaLightEngine
/*      */ {
/*      */   public static final String CHARSET_UTF8 = "UTF-8";
/*      */   public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
/*      */   public static final String CONTENT_TYPE_JSON = "application/json";
/*      */   public static final String ENCODING_GZIP = "gzip";
/*      */   public static final String HEADER_ACCEPT = "Accept";
/*      */   public static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";
/*      */   public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
/*      */   public static final String HEADER_AUTHORIZATION = "Authorization";
/*      */   public static final String HEADER_CACHE_CONTROL = "Cache-Control";
/*      */   public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
/*      */   public static final String HEADER_CONTENT_LENGTH = "Content-Length";
/*      */   public static final String HEADER_CONTENT_TYPE = "Content-Type";
/*      */   public static final String HEADER_DATE = "Date";
/*      */   public static final String HEADER_ETAG = "ETag";
/*      */   public static final String HEADER_EXPIRES = "Expires";
/*      */   public static final String HEADER_IF_NONE_MATCH = "If-None-Match";
/*      */   public static final String HEADER_LAST_MODIFIED = "Last-Modified";
/*      */   public static final String HEADER_LOCATION = "Location";
/*      */   public static final String HEADER_PROXY_AUTHORIZATION = "Proxy-Authorization";
/*      */   public static final String HEADER_REFERER = "Referer";
/*      */   public static final String HEADER_SERVER = "Server";
/*      */   public static final String HEADER_USER_AGENT = "User-Agent";
/*      */   public static final String METHOD_DELETE = "DELETE";
/*      */   public static final String METHOD_GET = "GET";
/*      */   public static final String METHOD_HEAD = "HEAD";
/*      */   public static final String METHOD_OPTIONS = "OPTIONS";
/*      */   public static final String METHOD_POST = "POST";
/*      */   public static final String METHOD_PATCH = "PATCH";
/*      */   public static final String METHOD_PUT = "PUT";
/*      */   public static final String METHOD_TRACE = "TRACE";
/*      */   public static final String PARAM_CHARSET = "charset";
/*      */   private static final String BOUNDARY = "00content0boundary00";
/*      */   private static final String CONTENT_TYPE_MULTIPART = "multipart/form-data; boundary=00content0boundary00";
/*      */   private static final String CRLF = "\r\n";
/*  252 */   private static final String[] EMPTY_STRINGS = new String[0];
/*      */   
/*      */   private static SSLSocketFactory TRUSTED_FACTORY;
/*      */   
/*      */   private static HostnameVerifier TRUSTED_VERIFIER;
/*      */   
/*      */   private static String getValidCharset(String charset) {
/*  259 */     if (charset != null && charset.length() > 0) {
/*  260 */       return charset;
/*      */     }
/*  262 */     return "UTF-8";
/*      */   }
/*      */ 
/*      */   
/*      */   private static SSLSocketFactory getTrustedFactory() throws HttpRequestException {
/*  267 */     if (TRUSTED_FACTORY == null) {
/*  268 */       TrustManager[] trustAllCerts = { new X509TrustManager()
/*      */           {
/*      */             public X509Certificate[] getAcceptedIssuers() {
/*  271 */               return new X509Certificate[0];
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             public void checkClientTrusted(X509Certificate[] chain, String authType) {}
/*      */ 
/*      */ 
/*      */             
/*      */             public void checkServerTrusted(X509Certificate[] chain, String authType) {}
/*      */           } };
/*      */       try {
/*  283 */         SSLContext context = SSLContext.getInstance("TLS");
/*  284 */         context.init(null, trustAllCerts, new SecureRandom());
/*  285 */         TRUSTED_FACTORY = context.getSocketFactory();
/*  286 */       } catch (GeneralSecurityException e) {
/*  287 */         IOException ioException = new IOException("Security exception configuring SSL context");
/*      */         
/*  289 */         ioException.initCause(e);
/*  290 */         throw new HttpRequestException(ioException);
/*      */       } 
/*      */     } 
/*      */     
/*  294 */     return TRUSTED_FACTORY;
/*      */   }
/*      */   
/*      */   private static HostnameVerifier getTrustedVerifier() {
/*  298 */     if (TRUSTED_VERIFIER == null) {
/*  299 */       TRUSTED_VERIFIER = new HostnameVerifier()
/*      */         {
/*      */           public boolean verify(String hostname, SSLSession session) {
/*  302 */             return true;
/*      */           }
/*      */         };
/*      */     }
/*  306 */     return TRUSTED_VERIFIER;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static StringBuilder addPathSeparator(String baseUrl, StringBuilder result) {
/*  315 */     if (baseUrl.indexOf(':') + 2 == baseUrl.lastIndexOf('/'))
/*  316 */       result.append('/'); 
/*  317 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static StringBuilder addParamPrefix(String baseUrl, StringBuilder result) {
/*  323 */     int queryStart = baseUrl.indexOf('?');
/*  324 */     int lastChar = result.length() - 1;
/*  325 */     if (queryStart == -1) {
/*  326 */       result.append('?');
/*  327 */     } else if (queryStart < lastChar && baseUrl.charAt(lastChar) != '&') {
/*  328 */       result.append('&');
/*  329 */     }  return result;
/*      */   }
/*      */ 
/*      */   
/*      */   private static StringBuilder addParam(Object key, Object<Object> value, StringBuilder result) {
/*  334 */     if (value != null && value.getClass().isArray()) {
/*  335 */       value = (Object<Object>)arrayToList(value);
/*      */     }
/*  337 */     if (value instanceof Iterable) {
/*  338 */       Iterator<?> iterator = ((Iterable)value).iterator();
/*  339 */       while (iterator.hasNext()) {
/*  340 */         result.append(key);
/*  341 */         result.append("[]=");
/*  342 */         Object element = iterator.next();
/*  343 */         if (element != null)
/*  344 */           result.append(element); 
/*  345 */         if (iterator.hasNext())
/*  346 */           result.append("&"); 
/*      */       } 
/*      */     } else {
/*  349 */       result.append(key);
/*  350 */       result.append("=");
/*  351 */       if (value != null) {
/*  352 */         result.append(value);
/*      */       }
/*      */     } 
/*  355 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface ConnectionFactory
/*      */   {
/*  382 */     public static final ConnectionFactory DEFAULT = new ConnectionFactory() {
/*      */         public HttpURLConnection create(URL url) throws IOException {
/*  384 */           return (HttpURLConnection)url.openConnection();
/*      */         }
/*      */         
/*      */         public HttpURLConnection create(URL url, Proxy proxy) throws IOException {
/*  388 */           return (HttpURLConnection)url.openConnection(proxy);
/*      */         }
/*      */       };
/*      */     HttpURLConnection create(URL param1URL) throws IOException;
/*      */     HttpURLConnection create(URL param1URL, Proxy param1Proxy) throws IOException; }
/*  393 */   private static ConnectionFactory CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setConnectionFactory(ConnectionFactory connectionFactory) {
/*  399 */     if (connectionFactory == null) {
/*  400 */       CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
/*      */     } else {
/*  402 */       CONNECTION_FACTORY = connectionFactory;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface UploadProgress
/*      */   {
/*  418 */     public static final UploadProgress DEFAULT = new UploadProgress()
/*      */       {
/*      */         public void onUpload(long uploaded, long total) {}
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void onUpload(long param1Long1, long param1Long2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Base64
/*      */   {
/*      */     private static final byte EQUALS_SIGN = 61;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String PREFERRED_ENCODING = "US-ASCII";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  449 */     private static final byte[] _STANDARD_ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static byte[] encode3to4(byte[] source, int srcOffset, int numSigBytes, byte[] destination, int destOffset) {
/*  499 */       byte[] ALPHABET = _STANDARD_ALPHABET;
/*      */       
/*  501 */       int inBuff = ((numSigBytes > 0) ? (source[srcOffset] << 24 >>> 8) : 0) | ((numSigBytes > 1) ? (source[srcOffset + 1] << 24 >>> 16) : 0) | ((numSigBytes > 2) ? (source[srcOffset + 2] << 24 >>> 24) : 0);
/*      */ 
/*      */ 
/*      */       
/*  505 */       switch (numSigBytes) {
/*      */         case 3:
/*  507 */           destination[destOffset] = ALPHABET[inBuff >>> 18];
/*  508 */           destination[destOffset + 1] = ALPHABET[inBuff >>> 12 & 0x3F];
/*  509 */           destination[destOffset + 2] = ALPHABET[inBuff >>> 6 & 0x3F];
/*  510 */           destination[destOffset + 3] = ALPHABET[inBuff & 0x3F];
/*  511 */           return destination;
/*      */         
/*      */         case 2:
/*  514 */           destination[destOffset] = ALPHABET[inBuff >>> 18];
/*  515 */           destination[destOffset + 1] = ALPHABET[inBuff >>> 12 & 0x3F];
/*  516 */           destination[destOffset + 2] = ALPHABET[inBuff >>> 6 & 0x3F];
/*  517 */           destination[destOffset + 3] = 61;
/*  518 */           return destination;
/*      */         
/*      */         case 1:
/*  521 */           destination[destOffset] = ALPHABET[inBuff >>> 18];
/*  522 */           destination[destOffset + 1] = ALPHABET[inBuff >>> 12 & 0x3F];
/*  523 */           destination[destOffset + 2] = 61;
/*  524 */           destination[destOffset + 3] = 61;
/*  525 */           return destination;
/*      */       } 
/*      */       
/*  528 */       return destination;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static String encode(String string) {
/*      */       byte[] bytes;
/*      */       try {
/*  541 */         bytes = string.getBytes("US-ASCII");
/*  542 */       } catch (UnsupportedEncodingException e) {
/*  543 */         bytes = string.getBytes();
/*      */       } 
/*  545 */       return encodeBytes(bytes);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static String encodeBytes(byte[] source) {
/*  561 */       return encodeBytes(source, 0, source.length);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static String encodeBytes(byte[] source, int off, int len) {
/*  581 */       byte[] encoded = encodeBytesToBytes(source, off, len);
/*      */       try {
/*  583 */         return new String(encoded, "US-ASCII");
/*  584 */       } catch (UnsupportedEncodingException uue) {
/*  585 */         return new String(encoded);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static byte[] encodeBytesToBytes(byte[] source, int off, int len) {
/*  610 */       if (source == null) {
/*  611 */         throw new NullPointerException("Cannot serialize a null array.");
/*      */       }
/*  613 */       if (off < 0) {
/*  614 */         throw new IllegalArgumentException("Cannot have negative offset: " + off);
/*      */       }
/*      */       
/*  617 */       if (len < 0) {
/*  618 */         throw new IllegalArgumentException("Cannot have length offset: " + len);
/*      */       }
/*  620 */       if (off + len > source.length) {
/*  621 */         throw new IllegalArgumentException(
/*      */             
/*  623 */             String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[] {
/*      */                 
/*  625 */                 Integer.valueOf(off), Integer.valueOf(len), Integer.valueOf(source.length)
/*      */               }));
/*      */       }
/*  628 */       int encLen = len / 3 * 4 + ((len % 3 > 0) ? 4 : 0);
/*      */       
/*  630 */       byte[] outBuff = new byte[encLen];
/*      */       
/*  632 */       int d = 0;
/*  633 */       int e = 0;
/*  634 */       int len2 = len - 2;
/*  635 */       for (; d < len2; d += 3, e += 4) {
/*  636 */         encode3to4(source, d + off, 3, outBuff, e);
/*      */       }
/*  638 */       if (d < len) {
/*  639 */         encode3to4(source, d + off, len - d, outBuff, e);
/*  640 */         e += 4;
/*      */       } 
/*      */       
/*  643 */       if (e <= outBuff.length - 1) {
/*  644 */         byte[] finalOut = new byte[e];
/*  645 */         System.arraycopy(outBuff, 0, finalOut, 0, e);
/*  646 */         return finalOut;
/*      */       } 
/*  648 */       return outBuff;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HttpRequestException
/*      */     extends RuntimeException
/*      */   {
/*      */     private static final long serialVersionUID = -1170466989781746231L;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HttpRequestException(IOException cause) {
/*  665 */       super(cause);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public IOException getCause() {
/*  675 */       return (IOException)super.getCause();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static abstract class Operation<V>
/*      */     implements Callable<V>
/*      */   {
/*      */     protected abstract V run() throws VanillaLightEngine.HttpRequestException, IOException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected abstract void done() throws IOException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V call() throws VanillaLightEngine.HttpRequestException {
/*  704 */       boolean thrown = false;
/*      */       try {
/*  706 */         return run();
/*  707 */       } catch (HttpRequestException e) {
/*  708 */         thrown = true;
/*  709 */         throw e;
/*  710 */       } catch (IOException e) {
/*  711 */         thrown = true;
/*  712 */         throw new VanillaLightEngine.HttpRequestException(e);
/*      */       } finally {
/*      */         try {
/*  715 */           done();
/*  716 */         } catch (IOException e) {
/*  717 */           if (!thrown) {
/*  718 */             throw new VanillaLightEngine.HttpRequestException(e);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static abstract class CloseOperation<V>
/*      */     extends Operation<V>
/*      */   {
/*      */     private final Closeable closeable;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final boolean ignoreCloseExceptions;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected CloseOperation(Closeable closeable, boolean ignoreCloseExceptions) {
/*  744 */       this.closeable = closeable;
/*  745 */       this.ignoreCloseExceptions = ignoreCloseExceptions;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void done() throws IOException {
/*  750 */       if (this.closeable instanceof Flushable)
/*  751 */         ((Flushable)this.closeable).flush(); 
/*  752 */       if (this.ignoreCloseExceptions) {
/*      */         try {
/*  754 */           this.closeable.close();
/*  755 */         } catch (IOException iOException) {}
/*      */       }
/*      */       else {
/*      */         
/*  759 */         this.closeable.close();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static abstract class FlushOperation<V>
/*      */     extends Operation<V>
/*      */   {
/*      */     private final Flushable flushable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected FlushOperation(Flushable flushable) {
/*  779 */       this.flushable = flushable;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void done() throws IOException {
/*  784 */       this.flushable.flush();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class RequestOutputStream
/*      */     extends BufferedOutputStream
/*      */   {
/*      */     private final CharsetEncoder encoder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public RequestOutputStream(OutputStream stream, String charset, int bufferSize) {
/*  804 */       super(stream, bufferSize);
/*      */       
/*  806 */       this.encoder = Charset.forName(VanillaLightEngine.getValidCharset(charset)).newEncoder();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public RequestOutputStream write(String value) throws IOException {
/*  817 */       ByteBuffer bytes = this.encoder.encode(CharBuffer.wrap(value));
/*      */       
/*  819 */       write(bytes.array(), 0, bytes.limit());
/*      */       
/*  821 */       return this;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static List<Object> arrayToList(Object array) {
/*  831 */     if (array instanceof Object[]) {
/*  832 */       return Arrays.asList((Object[])array);
/*      */     }
/*  834 */     List<Object> result = new ArrayList();
/*      */     
/*  836 */     if (array instanceof int[]) {
/*  837 */       for (int value : (int[])array) result.add(Integer.valueOf(value)); 
/*  838 */     } else if (array instanceof boolean[]) {
/*  839 */       for (boolean value : (boolean[])array) result.add(Boolean.valueOf(value)); 
/*  840 */     } else if (array instanceof long[]) {
/*  841 */       for (long value : (long[])array) result.add(Long.valueOf(value)); 
/*  842 */     } else if (array instanceof float[]) {
/*  843 */       for (float value : (float[])array) result.add(Float.valueOf(value)); 
/*  844 */     } else if (array instanceof double[]) {
/*  845 */       for (double value : (double[])array) result.add(Double.valueOf(value)); 
/*  846 */     } else if (array instanceof short[]) {
/*  847 */       for (short value : (short[])array) result.add(Short.valueOf(value)); 
/*  848 */     } else if (array instanceof byte[]) {
/*  849 */       for (byte value : (byte[])array) result.add(Byte.valueOf(value)); 
/*  850 */     } else if (array instanceof char[]) {
/*  851 */       for (char value : (char[])array) result.add(Character.valueOf(value)); 
/*  852 */     }  return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String encode(CharSequence url) throws HttpRequestException {
/*      */     URL parsed;
/*      */     try {
/*  872 */       parsed = new URL(url.toString());
/*  873 */     } catch (IOException e) {
/*  874 */       throw new HttpRequestException(e);
/*      */     } 
/*      */     
/*  877 */     String host = parsed.getHost();
/*  878 */     int port = parsed.getPort();
/*  879 */     if (port != -1) {
/*  880 */       host = host + ':' + Integer.toString(port);
/*      */     }
/*      */     
/*      */     try {
/*  884 */       String encoded = (new URI(parsed.getProtocol(), host, parsed.getPath(), parsed.getQuery(), null)).toASCIIString();
/*  885 */       int paramsStart = encoded.indexOf('?');
/*  886 */       if (paramsStart > 0 && paramsStart + 1 < encoded.length())
/*      */       {
/*  888 */         encoded = encoded.substring(0, paramsStart + 1) + encoded.substring(paramsStart + 1).replace("+", "%2B"); } 
/*  889 */       return encoded;
/*  890 */     } catch (URISyntaxException e) {
/*  891 */       IOException io = new IOException("Parsing URI failed");
/*  892 */       io.initCause(e);
/*  893 */       throw new HttpRequestException(io);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String append(CharSequence url, Map<?, ?> params) {
/*  908 */     String baseUrl = url.toString();
/*  909 */     if (params == null || params.isEmpty()) {
/*  910 */       return baseUrl;
/*      */     }
/*  912 */     StringBuilder result = new StringBuilder(baseUrl);
/*      */     
/*  914 */     addPathSeparator(baseUrl, result);
/*  915 */     addParamPrefix(baseUrl, result);
/*      */ 
/*      */     
/*  918 */     Iterator<?> iterator = params.entrySet().iterator();
/*  919 */     Map.Entry<?, ?> entry = (Map.Entry<?, ?>)iterator.next();
/*  920 */     addParam(entry.getKey().toString(), entry.getValue(), result);
/*      */     
/*  922 */     while (iterator.hasNext()) {
/*  923 */       result.append('&');
/*  924 */       entry = (Map.Entry<?, ?>)iterator.next();
/*  925 */       addParam(entry.getKey().toString(), entry.getValue(), result);
/*      */     } 
/*      */     
/*  928 */     return result.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String append(CharSequence url, Object... params) {
/*  943 */     String baseUrl = url.toString();
/*  944 */     if (params == null || params.length == 0) {
/*  945 */       return baseUrl;
/*      */     }
/*  947 */     if (params.length % 2 != 0) {
/*  948 */       throw new IllegalArgumentException("Must specify an even number of parameter names/values");
/*      */     }
/*      */     
/*  951 */     StringBuilder result = new StringBuilder(baseUrl);
/*      */     
/*  953 */     addPathSeparator(baseUrl, result);
/*  954 */     addParamPrefix(baseUrl, result);
/*      */     
/*  956 */     addParam(params[0], params[1], result);
/*      */     
/*  958 */     for (int i = 2; i < params.length; i += 2) {
/*  959 */       result.append('&');
/*  960 */       addParam(params[i], params[i + 1], result);
/*      */     } 
/*      */     
/*  963 */     return result.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine get(CharSequence url) throws HttpRequestException {
/*  975 */     return new VanillaLightEngine(url, "GET");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine get(URL url) throws HttpRequestException {
/*  986 */     return new VanillaLightEngine(url, "GET");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine get(CharSequence baseUrl, Map<?, ?> params, boolean encode) {
/* 1005 */     String url = append(baseUrl, params);
/* 1006 */     return get(encode ? encode(url) : url);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine get(CharSequence baseUrl, boolean encode, Object... params) {
/* 1026 */     String url = append(baseUrl, params);
/* 1027 */     return get(encode ? encode(url) : url);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine post(CharSequence url) throws HttpRequestException {
/* 1039 */     return new VanillaLightEngine(url, "POST");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine post(URL url) throws HttpRequestException {
/* 1050 */     return new VanillaLightEngine(url, "POST");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine post(CharSequence baseUrl, Map<?, ?> params, boolean encode) {
/* 1069 */     String url = append(baseUrl, params);
/* 1070 */     return post(encode ? encode(url) : url);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine post(CharSequence baseUrl, boolean encode, Object... params) {
/* 1090 */     String url = append(baseUrl, params);
/* 1091 */     return post(encode ? encode(url) : url);
/*      */   }
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine patch(CharSequence url) throws HttpRequestException {
/* 1096 */     return new VanillaLightEngine(url, "PATCH");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine put(CharSequence url) throws HttpRequestException {
/* 1107 */     return new VanillaLightEngine(url, "PUT");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine put(URL url) throws HttpRequestException {
/* 1118 */     return new VanillaLightEngine(url, "PUT");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine put(CharSequence baseUrl, Map<?, ?> params, boolean encode) {
/* 1137 */     String url = append(baseUrl, params);
/* 1138 */     return put(encode ? encode(url) : url);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine put(CharSequence baseUrl, boolean encode, Object... params) {
/* 1158 */     String url = append(baseUrl, params);
/* 1159 */     return put(encode ? encode(url) : url);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine delete(CharSequence url) throws HttpRequestException {
/* 1171 */     return new VanillaLightEngine(url, "DELETE");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine delete(URL url) throws HttpRequestException {
/* 1182 */     return new VanillaLightEngine(url, "DELETE");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine delete(CharSequence baseUrl, Map<?, ?> params, boolean encode) {
/* 1201 */     String url = append(baseUrl, params);
/* 1202 */     return delete(encode ? encode(url) : url);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine delete(CharSequence baseUrl, boolean encode, Object... params) {
/* 1222 */     String url = append(baseUrl, params);
/* 1223 */     return delete(encode ? encode(url) : url);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine head(CharSequence url) throws HttpRequestException {
/* 1235 */     return new VanillaLightEngine(url, "HEAD");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine head(URL url) throws HttpRequestException {
/* 1246 */     return new VanillaLightEngine(url, "HEAD");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine head(CharSequence baseUrl, Map<?, ?> params, boolean encode) {
/* 1265 */     String url = append(baseUrl, params);
/* 1266 */     return head(encode ? encode(url) : url);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine head(CharSequence baseUrl, boolean encode, Object... params) {
/* 1286 */     String url = append(baseUrl, params);
/* 1287 */     return head(encode ? encode(url) : url);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine options(CharSequence url) throws HttpRequestException {
/* 1299 */     return new VanillaLightEngine(url, "OPTIONS");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine options(URL url) throws HttpRequestException {
/* 1310 */     return new VanillaLightEngine(url, "OPTIONS");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine trace(CharSequence url) throws HttpRequestException {
/* 1322 */     return new VanillaLightEngine(url, "TRACE");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static VanillaLightEngine trace(URL url) throws HttpRequestException {
/* 1333 */     return new VanillaLightEngine(url, "TRACE");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void keepAlive(boolean keepAlive) {
/* 1344 */     setProperty("http.keepAlive", Boolean.toString(keepAlive));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void maxConnections(int maxConnections) {
/* 1355 */     setProperty("http.maxConnections", Integer.toString(maxConnections));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void proxyHost(String host) {
/* 1367 */     setProperty("http.proxyHost", host);
/* 1368 */     setProperty("https.proxyHost", host);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void proxyPort(int port) {
/* 1380 */     String portValue = Integer.toString(port);
/* 1381 */     setProperty("http.proxyPort", portValue);
/* 1382 */     setProperty("https.proxyPort", portValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nonProxyHosts(String... hosts) {
/* 1395 */     if (hosts != null && hosts.length > 0) {
/* 1396 */       StringBuilder separated = new StringBuilder();
/* 1397 */       int last = hosts.length - 1;
/* 1398 */       for (int i = 0; i < last; i++)
/* 1399 */         separated.append(hosts[i]).append('|'); 
/* 1400 */       separated.append(hosts[last]);
/* 1401 */       setProperty("http.nonProxyHosts", separated.toString());
/*      */     } else {
/* 1403 */       setProperty("http.nonProxyHosts", null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String setProperty(final String name, final String value) {
/*      */     PrivilegedAction<String> action;
/* 1417 */     if (value != null) {
/* 1418 */       action = new PrivilegedAction<String>()
/*      */         {
/*      */           public String run() {
/* 1421 */             return System.setProperty(name, value);
/*      */           }
/*      */         };
/*      */     } else {
/* 1425 */       action = new PrivilegedAction<String>()
/*      */         {
/*      */           public String run() {
/* 1428 */             return System.clearProperty(name); }
/*      */         };
/*      */     } 
/* 1431 */     return AccessController.<String>doPrivileged(action);
/*      */   }
/*      */   
/* 1434 */   private HttpURLConnection connection = null;
/*      */   
/*      */   private final URL url;
/*      */   
/*      */   private final String requestMethod;
/*      */   
/*      */   private RequestOutputStream output;
/*      */   
/*      */   private boolean multipart;
/*      */   
/*      */   private boolean form;
/*      */   
/*      */   private boolean ignoreCloseExceptions = true;
/*      */   
/*      */   private boolean uncompress = false;
/*      */   
/* 1450 */   private int bufferSize = 8192;
/*      */   
/* 1452 */   private long totalSize = -1L;
/*      */   
/* 1454 */   private long totalWritten = 0L;
/*      */   
/*      */   private String httpProxyHost;
/*      */   
/*      */   private int httpProxyPort;
/*      */   
/* 1460 */   private UploadProgress progress = UploadProgress.DEFAULT;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine(CharSequence url, String method) throws HttpRequestException {
/*      */     try {
/* 1472 */       this.url = new URL(url.toString());
/* 1473 */     } catch (MalformedURLException e) {
/* 1474 */       throw new HttpRequestException(e);
/*      */     } 
/* 1476 */     this.requestMethod = method;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine(URL url, String method) throws HttpRequestException {
/* 1488 */     this.url = url;
/* 1489 */     this.requestMethod = method;
/*      */   }
/*      */   
/*      */   private Proxy createProxy() {
/* 1493 */     return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.httpProxyHost, this.httpProxyPort));
/*      */   }
/*      */   
/*      */   private HttpURLConnection createConnection() {
/*      */     try {
/*      */       HttpURLConnection connection;
/* 1499 */       if (this.httpProxyHost != null) {
/* 1500 */         connection = CONNECTION_FACTORY.create(this.url, createProxy());
/*      */       } else {
/* 1502 */         connection = CONNECTION_FACTORY.create(this.url);
/* 1503 */       }  connection.setRequestMethod(this.requestMethod);
/* 1504 */       return connection;
/* 1505 */     } catch (IOException e) {
/* 1506 */       throw new HttpRequestException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1512 */     return method() + ' ' + url();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HttpURLConnection getConnection() {
/* 1521 */     if (this.connection == null)
/* 1522 */       this.connection = createConnection(); 
/* 1523 */     return this.connection;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine ignoreCloseExceptions(boolean ignore) {
/* 1536 */     this.ignoreCloseExceptions = ignore;
/* 1537 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean ignoreCloseExceptions() {
/* 1547 */     return this.ignoreCloseExceptions;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int code() throws HttpRequestException {
/*      */     try {
/* 1558 */       closeOutput();
/* 1559 */       return getConnection().getResponseCode();
/* 1560 */     } catch (IOException e) {
/* 1561 */       throw new HttpRequestException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine code(AtomicInteger output) throws HttpRequestException {
/* 1575 */     output.set(code());
/* 1576 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean ok() throws HttpRequestException {
/* 1586 */     return (200 == code());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean created() throws HttpRequestException {
/* 1596 */     return (201 == code());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean noContent() throws HttpRequestException {
/* 1606 */     return (204 == code());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean serverError() throws HttpRequestException {
/* 1616 */     return (500 == code());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean badRequest() throws HttpRequestException {
/* 1626 */     return (400 == code());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean notFound() throws HttpRequestException {
/* 1636 */     return (404 == code());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean notModified() throws HttpRequestException {
/* 1646 */     return (304 == code());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String message() throws HttpRequestException {
/*      */     try {
/* 1657 */       closeOutput();
/* 1658 */       return getConnection().getResponseMessage();
/* 1659 */     } catch (IOException e) {
/* 1660 */       throw new HttpRequestException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine disconnect() {
/* 1670 */     getConnection().disconnect();
/* 1671 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine chunk(int size) {
/* 1681 */     getConnection().setChunkedStreamingMode(size);
/* 1682 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine bufferSize(int size) {
/* 1697 */     if (size < 1)
/* 1698 */       throw new IllegalArgumentException("Size must be greater than zero"); 
/* 1699 */     this.bufferSize = size;
/* 1700 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int bufferSize() {
/* 1711 */     return this.bufferSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine uncompress(boolean uncompress) {
/* 1733 */     this.uncompress = uncompress;
/* 1734 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ByteArrayOutputStream byteStream() {
/* 1743 */     int size = contentLength();
/* 1744 */     if (size > 0) {
/* 1745 */       return new ByteArrayOutputStream(size);
/*      */     }
/* 1747 */     return new ByteArrayOutputStream();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String body(String charset) throws HttpRequestException {
/* 1761 */     ByteArrayOutputStream output = byteStream();
/*      */     try {
/* 1763 */       copy(buffer(), output);
/* 1764 */       return output.toString(getValidCharset(charset));
/* 1765 */     } catch (IOException e) {
/* 1766 */       throw new HttpRequestException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String body() throws HttpRequestException {
/* 1778 */     return body(charset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine body(AtomicReference<String> output) throws HttpRequestException {
/* 1790 */     output.set(body());
/* 1791 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine body(AtomicReference<String> output, String charset) throws HttpRequestException {
/* 1804 */     output.set(body(charset));
/* 1805 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBodyEmpty() throws HttpRequestException {
/* 1816 */     return (contentLength() == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] bytes() throws HttpRequestException {
/* 1826 */     ByteArrayOutputStream output = byteStream();
/*      */     try {
/* 1828 */       copy(buffer(), output);
/* 1829 */     } catch (IOException e) {
/* 1830 */       throw new HttpRequestException(e);
/*      */     } 
/* 1832 */     return output.toByteArray();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedInputStream buffer() throws HttpRequestException {
/* 1843 */     return new BufferedInputStream(stream(), this.bufferSize);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InputStream stream() throws HttpRequestException {
/*      */     InputStream stream;
/* 1854 */     if (code() < 400) {
/*      */       try {
/* 1856 */         stream = getConnection().getInputStream();
/* 1857 */       } catch (IOException e) {
/* 1858 */         throw new HttpRequestException(e);
/*      */       } 
/*      */     } else {
/* 1861 */       stream = getConnection().getErrorStream();
/* 1862 */       if (stream == null) {
/*      */         try {
/* 1864 */           stream = getConnection().getInputStream();
/* 1865 */         } catch (IOException e) {
/* 1866 */           if (contentLength() > 0) {
/* 1867 */             throw new HttpRequestException(e);
/*      */           }
/* 1869 */           stream = new ByteArrayInputStream(new byte[0]);
/*      */         } 
/*      */       }
/*      */     } 
/* 1873 */     if (!this.uncompress || !"gzip".equals(contentEncoding())) {
/* 1874 */       return stream;
/*      */     }
/*      */     try {
/* 1877 */       return new GZIPInputStream(stream);
/* 1878 */     } catch (IOException e) {
/* 1879 */       throw new HttpRequestException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InputStreamReader reader(String charset) throws HttpRequestException {
/*      */     try {
/* 1896 */       return new InputStreamReader(stream(), getValidCharset(charset));
/* 1897 */     } catch (UnsupportedEncodingException e) {
/* 1898 */       throw new HttpRequestException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InputStreamReader reader() throws HttpRequestException {
/* 1910 */     return reader(charset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader bufferedReader(String charset) throws HttpRequestException {
/* 1925 */     return new BufferedReader(reader(charset), this.bufferSize);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader bufferedReader() throws HttpRequestException {
/* 1937 */     return bufferedReader(charset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine receive(File file) throws HttpRequestException {
/*      */     final OutputStream output;
/*      */     try {
/* 1950 */       output = new BufferedOutputStream(new FileOutputStream(file), this.bufferSize);
/* 1951 */     } catch (FileNotFoundException e) {
/* 1952 */       throw new HttpRequestException(e);
/*      */     } 
/* 1954 */     return (new CloseOperation<VanillaLightEngine>(output, this.ignoreCloseExceptions)
/*      */       {
/*      */         protected VanillaLightEngine run() throws VanillaLightEngine.HttpRequestException, IOException
/*      */         {
/* 1958 */           return VanillaLightEngine.this.receive(output);
/*      */         }
/* 1960 */       }).call();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine receive(OutputStream output) throws HttpRequestException {
/*      */     try {
/* 1973 */       return copy(buffer(), output);
/* 1974 */     } catch (IOException e) {
/* 1975 */       throw new HttpRequestException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine receive(PrintStream output) throws HttpRequestException {
/* 1988 */     return receive(output);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine receive(final Appendable appendable) throws HttpRequestException {
/* 2000 */     final BufferedReader reader = bufferedReader();
/* 2001 */     return (new CloseOperation<VanillaLightEngine>(reader, this.ignoreCloseExceptions)
/*      */       {
/*      */         public VanillaLightEngine run() throws IOException
/*      */         {
/* 2005 */           CharBuffer buffer = CharBuffer.allocate(VanillaLightEngine.this.bufferSize);
/*      */           int read;
/* 2007 */           while ((read = reader.read(buffer)) != -1) {
/* 2008 */             buffer.rewind();
/* 2009 */             appendable.append(buffer, 0, read);
/* 2010 */             buffer.rewind();
/*      */           } 
/* 2012 */           return VanillaLightEngine.this;
/*      */         }
/* 2014 */       }).call();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine receive(final Writer writer) throws HttpRequestException {
/* 2025 */     final BufferedReader reader = bufferedReader();
/* 2026 */     return (new CloseOperation<VanillaLightEngine>(reader, this.ignoreCloseExceptions)
/*      */       {
/*      */         public VanillaLightEngine run() throws IOException
/*      */         {
/* 2030 */           return VanillaLightEngine.this.copy(reader, writer);
/*      */         }
/* 2032 */       }).call();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine readTimeout(int timeout) {
/* 2042 */     getConnection().setReadTimeout(timeout);
/* 2043 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine connectTimeout(int timeout) {
/* 2053 */     getConnection().setConnectTimeout(timeout);
/* 2054 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine header(String name, String value) {
/* 2065 */     getConnection().setRequestProperty(name, value);
/* 2066 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine header(String name, Number value) {
/* 2077 */     return header(name, (value != null) ? value.toString() : null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine headers(Map<String, String> headers) {
/* 2088 */     if (!headers.isEmpty())
/* 2089 */       for (Map.Entry<String, String> header : headers.entrySet())
/* 2090 */         header(header);  
/* 2091 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine header(Map.Entry<String, String> header) {
/* 2101 */     return header(header.getKey(), header.getValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String header(String name) throws HttpRequestException {
/* 2112 */     closeOutputQuietly();
/* 2113 */     return getConnection().getHeaderField(name);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, List<String>> headers() throws HttpRequestException {
/* 2123 */     closeOutputQuietly();
/* 2124 */     return getConnection().getHeaderFields();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long dateHeader(String name) throws HttpRequestException {
/* 2136 */     return dateHeader(name, -1L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long dateHeader(String name, long defaultValue) throws HttpRequestException {
/* 2150 */     closeOutputQuietly();
/* 2151 */     return getConnection().getHeaderFieldDate(name, defaultValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int intHeader(String name) throws HttpRequestException {
/* 2163 */     return intHeader(name, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int intHeader(String name, int defaultValue) throws HttpRequestException {
/* 2178 */     closeOutputQuietly();
/* 2179 */     return getConnection().getHeaderFieldInt(name, defaultValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] headers(String name) {
/* 2189 */     Map<String, List<String>> headers = headers();
/* 2190 */     if (headers == null || headers.isEmpty()) {
/* 2191 */       return EMPTY_STRINGS;
/*      */     }
/* 2193 */     List<String> values = headers.get(name);
/* 2194 */     if (values != null && !values.isEmpty()) {
/* 2195 */       return values.<String>toArray(new String[values.size()]);
/*      */     }
/* 2197 */     return EMPTY_STRINGS;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String parameter(String headerName, String paramName) {
/* 2208 */     return getParam(header(headerName), paramName);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, String> parameters(String headerName) {
/* 2221 */     return getParams(header(headerName));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Map<String, String> getParams(String header) {
/* 2231 */     if (header == null || header.length() == 0) {
/* 2232 */       return Collections.emptyMap();
/*      */     }
/* 2234 */     int headerLength = header.length();
/* 2235 */     int start = header.indexOf(';') + 1;
/* 2236 */     if (start == 0 || start == headerLength) {
/* 2237 */       return Collections.emptyMap();
/*      */     }
/* 2239 */     int end = header.indexOf(';', start);
/* 2240 */     if (end == -1) {
/* 2241 */       end = headerLength;
/*      */     }
/* 2243 */     Map<String, String> params = new LinkedHashMap<>();
/* 2244 */     while (start < end) {
/* 2245 */       int nameEnd = header.indexOf('=', start);
/* 2246 */       if (nameEnd != -1 && nameEnd < end) {
/* 2247 */         String name = header.substring(start, nameEnd).trim();
/* 2248 */         if (name.length() > 0) {
/* 2249 */           String value = header.substring(nameEnd + 1, end).trim();
/* 2250 */           int length = value.length();
/* 2251 */           if (length != 0)
/* 2252 */             if (length > 2 && '"' == value.charAt(0) && '"' == value
/* 2253 */               .charAt(length - 1)) {
/* 2254 */               params.put(name, value.substring(1, length - 1));
/*      */             } else {
/* 2256 */               params.put(name, value);
/*      */             }  
/*      */         } 
/*      */       } 
/* 2260 */       start = end + 1;
/* 2261 */       end = header.indexOf(';', start);
/* 2262 */       if (end == -1) {
/* 2263 */         end = headerLength;
/*      */       }
/*      */     } 
/* 2266 */     return params;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getParam(String value, String paramName) {
/* 2277 */     if (value == null || value.length() == 0) {
/* 2278 */       return null;
/*      */     }
/* 2280 */     int length = value.length();
/* 2281 */     int start = value.indexOf(';') + 1;
/* 2282 */     if (start == 0 || start == length) {
/* 2283 */       return null;
/*      */     }
/* 2285 */     int end = value.indexOf(';', start);
/* 2286 */     if (end == -1) {
/* 2287 */       end = length;
/*      */     }
/* 2289 */     while (start < end) {
/* 2290 */       int nameEnd = value.indexOf('=', start);
/* 2291 */       if (nameEnd != -1 && nameEnd < end && paramName
/* 2292 */         .equals(value.substring(start, nameEnd).trim())) {
/* 2293 */         String paramValue = value.substring(nameEnd + 1, end).trim();
/* 2294 */         int valueLength = paramValue.length();
/* 2295 */         if (valueLength != 0) {
/* 2296 */           if (valueLength > 2 && '"' == paramValue.charAt(0) && '"' == paramValue
/* 2297 */             .charAt(valueLength - 1)) {
/* 2298 */             return paramValue.substring(1, valueLength - 1);
/*      */           }
/* 2300 */           return paramValue;
/*      */         } 
/*      */       } 
/* 2303 */       start = end + 1;
/* 2304 */       end = value.indexOf(';', start);
/* 2305 */       if (end == -1) {
/* 2306 */         end = length;
/*      */       }
/*      */     } 
/* 2309 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String charset() {
/* 2318 */     return parameter("Content-Type", "charset");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine userAgent(String userAgent) {
/* 2328 */     return header("User-Agent", userAgent);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine referer(String referer) {
/* 2338 */     return header("Referer", referer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine useCaches(boolean useCaches) {
/* 2348 */     getConnection().setUseCaches(useCaches);
/* 2349 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine acceptEncoding(String acceptEncoding) {
/* 2359 */     return header("Accept-Encoding", acceptEncoding);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine acceptGzipEncoding() {
/* 2369 */     return acceptEncoding("gzip");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine acceptCharset(String acceptCharset) {
/* 2379 */     return header("Accept-Charset", acceptCharset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String contentEncoding() {
/* 2388 */     return header("Content-Encoding");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String server() {
/* 2397 */     return header("Server");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long date() {
/* 2406 */     return dateHeader("Date");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String cacheControl() {
/* 2415 */     return header("Cache-Control");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String eTag() {
/* 2424 */     return header("ETag");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long expires() {
/* 2433 */     return dateHeader("Expires");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long lastModified() {
/* 2442 */     return dateHeader("Last-Modified");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String location() {
/* 2451 */     return header("Location");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine authorization(String authorization) {
/* 2461 */     return header("Authorization", authorization);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine proxyAuthorization(String proxyAuthorization) {
/* 2471 */     return header("Proxy-Authorization", proxyAuthorization);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine basic(String name, String password) {
/* 2483 */     return authorization("Basic " + Base64.encode(name + ':' + password));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine proxyBasic(String name, String password) {
/* 2495 */     return proxyAuthorization("Basic " + Base64.encode(name + ':' + password));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine ifModifiedSince(long ifModifiedSince) {
/* 2505 */     getConnection().setIfModifiedSince(ifModifiedSince);
/* 2506 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine ifNoneMatch(String ifNoneMatch) {
/* 2516 */     return header("If-None-Match", ifNoneMatch);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine contentType(String contentType) {
/* 2526 */     return contentType(contentType, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine contentType(String contentType, String charset) {
/* 2537 */     if (charset != null && charset.length() > 0) {
/* 2538 */       String separator = "; charset=";
/* 2539 */       return header("Content-Type", contentType + "; charset=" + charset);
/*      */     } 
/* 2541 */     return header("Content-Type", contentType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String contentType() {
/* 2550 */     return header("Content-Type");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int contentLength() {
/* 2559 */     return intHeader("Content-Length");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine contentLength(String contentLength) {
/* 2569 */     return contentLength(Integer.parseInt(contentLength));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine contentLength(int contentLength) {
/* 2579 */     getConnection().setFixedLengthStreamingMode(contentLength);
/* 2580 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine accept(String accept) {
/* 2590 */     return header("Accept", accept);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine acceptJson() {
/* 2599 */     return accept("application/json");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected VanillaLightEngine copy(final InputStream input, final OutputStream output) throws IOException {
/* 2612 */     return (new CloseOperation<VanillaLightEngine>(input, this.ignoreCloseExceptions)
/*      */       {
/*      */         public VanillaLightEngine run() throws IOException
/*      */         {
/* 2616 */           byte[] buffer = new byte[VanillaLightEngine.this.bufferSize];
/*      */           int read;
/* 2618 */           while ((read = input.read(buffer)) != -1) {
/* 2619 */             output.write(buffer, 0, read);
/* 2620 */             VanillaLightEngine.this.totalWritten = VanillaLightEngine.this.totalWritten + read;
/* 2621 */             VanillaLightEngine.this.progress.onUpload(VanillaLightEngine.this.totalWritten, VanillaLightEngine.this.totalSize);
/*      */           } 
/* 2623 */           return VanillaLightEngine.this;
/*      */         }
/* 2625 */       }).call();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected VanillaLightEngine copy(final Reader input, final Writer output) throws IOException {
/* 2638 */     return (new CloseOperation<VanillaLightEngine>(input, this.ignoreCloseExceptions)
/*      */       {
/*      */         public VanillaLightEngine run() throws IOException
/*      */         {
/* 2642 */           char[] buffer = new char[VanillaLightEngine.this.bufferSize];
/*      */           int read;
/* 2644 */           while ((read = input.read(buffer)) != -1) {
/* 2645 */             output.write(buffer, 0, read);
/* 2646 */             VanillaLightEngine.this.totalWritten = VanillaLightEngine.this.totalWritten + read;
/* 2647 */             VanillaLightEngine.this.progress.onUpload(VanillaLightEngine.this.totalWritten, -1L);
/*      */           } 
/* 2649 */           return VanillaLightEngine.this;
/*      */         }
/* 2651 */       }).call();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine progress(UploadProgress callback) {
/* 2661 */     if (callback == null) {
/* 2662 */       this.progress = UploadProgress.DEFAULT;
/*      */     } else {
/* 2664 */       this.progress = callback;
/* 2665 */     }  return this;
/*      */   }
/*      */   
/*      */   private VanillaLightEngine incrementTotalSize(long size) {
/* 2669 */     if (this.totalSize == -1L)
/* 2670 */       this.totalSize = 0L; 
/* 2671 */     this.totalSize += size;
/* 2672 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected VanillaLightEngine closeOutput() throws IOException {
/* 2683 */     progress(null);
/* 2684 */     if (this.output == null)
/* 2685 */       return this; 
/* 2686 */     if (this.multipart)
/* 2687 */       this.output.write("\r\n--00content0boundary00--\r\n"); 
/* 2688 */     if (this.ignoreCloseExceptions) {
/*      */       try {
/* 2690 */         this.output.close();
/* 2691 */       } catch (IOException iOException) {}
/*      */     }
/*      */     else {
/*      */       
/* 2695 */       this.output.close();
/* 2696 */     }  this.output = null;
/* 2697 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected VanillaLightEngine closeOutputQuietly() throws HttpRequestException {
/*      */     try {
/* 2709 */       return closeOutput();
/* 2710 */     } catch (IOException e) {
/* 2711 */       throw new HttpRequestException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected VanillaLightEngine openOutput() throws IOException {
/* 2722 */     if (this.output != null)
/* 2723 */       return this; 
/* 2724 */     getConnection().setDoOutput(true);
/* 2725 */     String charset = getParam(
/* 2726 */         getConnection().getRequestProperty("Content-Type"), "charset");
/* 2727 */     this.output = new RequestOutputStream(getConnection().getOutputStream(), charset, this.bufferSize);
/*      */     
/* 2729 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected VanillaLightEngine startPart() throws IOException {
/* 2739 */     if (!this.multipart) {
/* 2740 */       this.multipart = true;
/* 2741 */       contentType("multipart/form-data; boundary=00content0boundary00").openOutput();
/* 2742 */       this.output.write("--00content0boundary00\r\n");
/*      */     } else {
/* 2744 */       this.output.write("\r\n--00content0boundary00\r\n");
/* 2745 */     }  return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected VanillaLightEngine writePartHeader(String name, String filename) throws IOException {
/* 2758 */     return writePartHeader(name, filename, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected VanillaLightEngine writePartHeader(String name, String filename, String contentType) throws IOException {
/* 2772 */     StringBuilder partBuffer = new StringBuilder();
/* 2773 */     partBuffer.append("form-data; name=\"").append(name);
/* 2774 */     if (filename != null)
/* 2775 */       partBuffer.append("\"; filename=\"").append(filename); 
/* 2776 */     partBuffer.append('"');
/* 2777 */     partHeader("Content-Disposition", partBuffer.toString());
/* 2778 */     if (contentType != null)
/* 2779 */       partHeader("Content-Type", contentType); 
/* 2780 */     return send("\r\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine part(String name, String part) {
/* 2791 */     return part(name, (String)null, part);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine part(String name, String filename, String part) throws HttpRequestException {
/* 2805 */     return part(name, filename, (String)null, part);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine part(String name, String filename, String contentType, String part) throws HttpRequestException {
/*      */     try {
/* 2822 */       startPart();
/* 2823 */       writePartHeader(name, filename, contentType);
/* 2824 */       this.output.write(part);
/* 2825 */     } catch (IOException e) {
/* 2826 */       throw new HttpRequestException(e);
/*      */     } 
/* 2828 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine part(String name, Number part) throws HttpRequestException {
/* 2841 */     return part(name, (String)null, part);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine part(String name, String filename, Number part) throws HttpRequestException {
/* 2855 */     return part(name, filename, (part != null) ? part.toString() : null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine part(String name, File part) throws HttpRequestException {
/* 2868 */     return part(name, (String)null, part);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine part(String name, String filename, File part) throws HttpRequestException {
/* 2882 */     return part(name, filename, (String)null, part);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine part(String name, String filename, String contentType, File part) throws HttpRequestException {
/*      */     InputStream stream;
/*      */     try {
/* 2900 */       stream = new BufferedInputStream(new FileInputStream(part));
/* 2901 */       incrementTotalSize(part.length());
/* 2902 */     } catch (IOException e) {
/* 2903 */       throw new HttpRequestException(e);
/*      */     } 
/* 2905 */     return part(name, filename, contentType, stream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine part(String name, InputStream part) throws HttpRequestException {
/* 2918 */     return part(name, (String)null, (String)null, part);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine part(String name, String filename, String contentType, InputStream part) throws HttpRequestException {
/*      */     try {
/* 2936 */       startPart();
/* 2937 */       writePartHeader(name, filename, contentType);
/* 2938 */       copy(part, this.output);
/* 2939 */     } catch (IOException e) {
/* 2940 */       throw new HttpRequestException(e);
/*      */     } 
/* 2942 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine partHeader(String name, String value) throws HttpRequestException {
/* 2955 */     return send(name).send(": ").send(value).send("\r\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine send(File input) throws HttpRequestException {
/*      */     InputStream stream;
/*      */     try {
/* 2968 */       stream = new BufferedInputStream(new FileInputStream(input));
/* 2969 */       incrementTotalSize(input.length());
/* 2970 */     } catch (FileNotFoundException e) {
/* 2971 */       throw new HttpRequestException(e);
/*      */     } 
/* 2973 */     return send(stream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine send(byte[] input) throws HttpRequestException {
/* 2984 */     if (input != null)
/* 2985 */       incrementTotalSize(input.length); 
/* 2986 */     return send(new ByteArrayInputStream(input));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine send(InputStream input) throws HttpRequestException {
/*      */     try {
/* 3000 */       openOutput();
/* 3001 */       copy(input, this.output);
/* 3002 */     } catch (IOException e) {
/* 3003 */       throw new HttpRequestException(e);
/*      */     } 
/* 3005 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine send(final Reader input) throws HttpRequestException {
/*      */     try {
/* 3019 */       openOutput();
/* 3020 */     } catch (IOException e) {
/* 3021 */       throw new HttpRequestException(e);
/*      */     } 
/*      */     
/* 3024 */     final Writer writer = new OutputStreamWriter(this.output, this.output.encoder.charset());
/* 3025 */     return (new FlushOperation<VanillaLightEngine>(writer)
/*      */       {
/*      */         protected VanillaLightEngine run() throws IOException
/*      */         {
/* 3029 */           return VanillaLightEngine.this.copy(input, writer);
/*      */         }
/* 3031 */       }).call();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine send(CharSequence value) throws HttpRequestException {
/*      */     try {
/* 3046 */       openOutput();
/* 3047 */       this.output.write(value.toString());
/* 3048 */     } catch (IOException e) {
/* 3049 */       throw new HttpRequestException(e);
/*      */     } 
/* 3051 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public OutputStreamWriter writer() throws HttpRequestException {
/*      */     try {
/* 3062 */       openOutput();
/* 3063 */       return new OutputStreamWriter(this.output, this.output.encoder.charset());
/* 3064 */     } catch (IOException e) {
/* 3065 */       throw new HttpRequestException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine form(Map<?, ?> values) throws HttpRequestException {
/* 3080 */     return form(values, "UTF-8");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine form(Map.Entry<?, ?> entry) throws HttpRequestException {
/* 3094 */     return form(entry, "UTF-8");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine form(Map.Entry<?, ?> entry, String charset) throws HttpRequestException {
/* 3110 */     return form(entry.getKey(), entry.getValue(), charset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine form(Object name, Object value) throws HttpRequestException {
/* 3126 */     return form(name, value, "UTF-8");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine form(Object name, Object value, String charset) throws HttpRequestException {
/* 3143 */     boolean first = !this.form;
/* 3144 */     if (first) {
/* 3145 */       contentType("application/x-www-form-urlencoded", charset);
/* 3146 */       this.form = true;
/*      */     } 
/* 3148 */     charset = getValidCharset(charset);
/*      */     try {
/* 3150 */       openOutput();
/* 3151 */       if (!first)
/* 3152 */         this.output.write(38); 
/* 3153 */       this.output.write(URLEncoder.encode(name.toString(), charset));
/* 3154 */       this.output.write(61);
/* 3155 */       if (value != null)
/* 3156 */         this.output.write(URLEncoder.encode(value.toString(), charset)); 
/* 3157 */     } catch (IOException e) {
/* 3158 */       throw new HttpRequestException(e);
/*      */     } 
/* 3160 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine form(Map<?, ?> values, String charset) throws HttpRequestException {
/* 3173 */     if (!values.isEmpty())
/* 3174 */       for (Map.Entry<?, ?> entry : values.entrySet())
/* 3175 */         form(entry, charset);  
/* 3176 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine trustAllCerts() throws HttpRequestException {
/* 3188 */     HttpURLConnection connection = getConnection();
/* 3189 */     if (connection instanceof HttpsURLConnection)
/* 3190 */       ((HttpsURLConnection)connection)
/* 3191 */         .setSSLSocketFactory(getTrustedFactory()); 
/* 3192 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine trustAllHosts() {
/* 3205 */     HttpURLConnection connection = getConnection();
/* 3206 */     if (connection instanceof HttpsURLConnection)
/* 3207 */       ((HttpsURLConnection)connection)
/* 3208 */         .setHostnameVerifier(getTrustedVerifier()); 
/* 3209 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public URL url() {
/* 3218 */     return getConnection().getURL();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String method() {
/* 3227 */     return getConnection().getRequestMethod();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine useProxy(String proxyHost, int proxyPort) {
/* 3239 */     if (this.connection != null) {
/* 3240 */       throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
/*      */     }
/* 3242 */     this.httpProxyHost = proxyHost;
/* 3243 */     this.httpProxyPort = proxyPort;
/* 3244 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VanillaLightEngine followRedirects(boolean followRedirects) {
/* 3255 */     getConnection().setInstanceFollowRedirects(followRedirects);
/* 3256 */     return this;
/*      */   }
/*      */ }


/* Location:              C:\Users\SusanLindsay\Downloads\JabHak.safe.jar!\me\noculator\tweaks\VanillaLightEngine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */